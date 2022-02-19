package com.example.numad22sp_xiaohuli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;




public class LocatorActivity extends AppCompatActivity {

    TextView latitude, longitude;
    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;
    private static final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);

        latitude = findViewById(R.id.tvLatitude);
        longitude = findViewById(R.id.tvLongitude);

        locationRequest = new LocationRequest();
        locationRequest.setFastestInterval(4000);
        locationRequest.setInterval(20000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        GPSChange();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    GPSChange();
                }
                else {
                    Toast.makeText(this, "App requires permissions", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    private void GPSChange(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(LocatorActivity.this);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    locationChange(location);
                }
            });
        }
        else{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE);
            }
        }
    }

    private void locationChange(Location location){
        latitude.setText("Latitude: " + location.getLatitude());
        longitude.setText("Longitude: " + location.getLongitude());
    }







}