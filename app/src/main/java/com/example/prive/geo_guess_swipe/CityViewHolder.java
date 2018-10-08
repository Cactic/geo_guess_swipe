package com.example.prive.geo_guess_swipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CityViewHolder extends RecyclerView.ViewHolder {

    public ImageView cityImage;
    public View view;

    public CityViewHolder(View itemView) {
        super(itemView);
        cityImage = (ImageView) itemView.findViewById((R.id.cityImage));
        view = itemView;
    }

}
