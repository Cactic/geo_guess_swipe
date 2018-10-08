package com.example.prive.geo_guess_swipe;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<CityViewHolder> {

    private Context context;
    public List<Photos> photosList;

    public Adapter(Context context, List<Photos> photosList){
        this.context = context;
        this.photosList = photosList;

    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.grid_cell,parent,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CityViewHolder holder, final int position) {
        final Photos photos = photosList.get(position);
        holder.cityImage.setImageResource(photos.getImageName());
    }

    public int getItemCount(){
        return photosList.size();
    }
}
