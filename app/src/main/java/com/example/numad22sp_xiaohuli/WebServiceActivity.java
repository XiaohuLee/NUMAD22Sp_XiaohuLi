package com.example.numad22sp_xiaohuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WebServiceActivity extends AppCompatActivity {

    private static final String TAG = "WebServiceActivity";

    private EditText mURLEditText;
    private TextView mTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        mURLEditText = (EditText)findViewById(R.id.URL_editText);
        mTitleTextView = (TextView)findViewById(R.id.result_textview);

    }

    public void callWebserviceButtonHandler(View view){
        PingWebServiceTask task = new PingWebServiceTask();
        try {
            String url = NetworkUtil.validInput(mURLEditText.getText().toString());
            task.execute(url); // This is a security risk.  Don't let your user enter the URL in a real app.
        } catch (NetworkUtil.MyException e) {
            Toast.makeText(getApplication(),e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    // Google is deprecating Android AsyncTask API in Android 11 and suggesting to use java.util.concurrent
    // But it is still important to learn&manage how it works
    private class PingWebServiceTask  extends AsyncTask<String, Integer, JSONObject> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        @Override
        protected JSONObject doInBackground(String... params) {

            JSONObject jObject = new JSONObject();
            try {

                // Initial website is "https://jsonplaceholder.typicode.com/posts/1"
                URL url = new URL(params[0]);
                // Get String response from the url address
                String resp = NetworkUtil.httpResponse(url);
                //Log.i("resp",resp);

                // JSONArray jArray = new JSONArray(resp);    // Use this if your web service returns an array of objects.  Arrays are in [ ] brackets.
                // Transform String into JSONObject
                jObject = new JSONObject(resp);

                //Log.i("jTitle",jObject.getString("title"));
                //Log.i("jBody",jObject.getString("body"));
                return jObject;

            } catch (MalformedURLException e) {
                Log.e(TAG,"MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                Log.e(TAG,"ProtocolException");
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG,"IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG,"JSONException");
                e.printStackTrace();
            }

            return jObject;
        }

        @Override
        protected void onPostExecute(JSONObject jObject) {
            super.onPostExecute(jObject);
            TextView location_view = (TextView) findViewById(R.id.tvLocation);
            TextView country_view = (TextView) findViewById(R.id.tvCountry);
            TextView result_view = (TextView)findViewById(R.id.result_textview);
            TextView observationTime_view = (TextView) findViewById(R.id.tvObservation);
            TextView temperature_view = (TextView) findViewById(R.id.tvTemperature);
            TextView weatherDesc_view = (TextView) findViewById(R.id.tvWeatherDesc);
            TextView windSpeed_view = (TextView) findViewById(R.id.tvWindSpeed);
            TextView windDegree_view = (TextView) findViewById(R.id.tvWindDegree);
            TextView windDir_view = (TextView) findViewById(R.id.tvWindDir);
            TextView pressure_view = (TextView) findViewById(R.id.tvPressure);
            TextView humidity_view = (TextView) findViewById(R.id.tvHumidity);
            TextView feelsLike_view = (TextView) findViewById(R.id.tvFeelslike);
            TextView visibility_view = (TextView) findViewById(R.id.tvVisibility);

            try {
                result_view.setText(jObject.getString("current"));
                JSONObject jObject_location = new JSONObject(jObject.getString("location"));
                JSONObject jObject_current = new JSONObject(jObject.getString("current"));

                location_view.setText("Location: " + jObject_location.getString("name"));
                country_view.setText("Country: " + jObject_location.getString("country"));

                observationTime_view.setText("Observation Time: " + jObject_current.getString("observation_time"));
                temperature_view.setText("Temperature: " + jObject_current.getString("temperature"));
                JSONArray jArray = new JSONArray(jObject_current.getString("weather_descriptions"));
                weatherDesc_view.setText("Weather Description: " + jArray.getString(0));
                windSpeed_view.setText("Wind Speed: " + jObject_current.getString("wind_speed"));
                windDegree_view.setText("Wind Degree: " + jObject_current.getString("wind_degree"));
                windDir_view.setText("Wind Direction: " + jObject_current.getString("wind_dir"));
                pressure_view.setText("Pressure: " + jObject_current.getString("pressure"));
                humidity_view.setText("Humidity: " + jObject_current.getString("humidity"));
                feelsLike_view.setText("Feels Like: " + jObject_current.getString("feelslike"));
                visibility_view.setText("Visibility: " + jObject_current.getString("visibility"));

            } catch (JSONException e) {
                result_view.setText("Something went wrong!");
            }

        }
    }

}
