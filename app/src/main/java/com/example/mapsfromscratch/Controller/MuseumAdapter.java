package com.example.mapsfromscratch.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mapsfromscratch.Model.MuseumObject;
import com.example.mapsfromscratch.R;
import com.example.mapsfromscratch.View.MuseumViewHolder;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {
    private List<MuseumObject> museumList;

    public MuseumAdapter(List<MuseumObject> museumList) {
        this.museumList = museumList;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_museum, viewGroup, false);

        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder museumViewHolder, int position) {
        museumViewHolder.onBind(museumList.get(position));
    }


    @Override
    public int getItemCount() {
        return museumList.size();
    }
}
