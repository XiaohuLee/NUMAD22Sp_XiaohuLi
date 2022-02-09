package com.example.numad22sp_xiaohuli;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemDesc;

    public RviewHolder(View itemView, final ItemClickListener listener) {
        super(itemView);

        itemName = itemView.findViewById(R.id.item_name);
        itemDesc = itemView.findViewById(R.id.item_desc);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });


    }
}
