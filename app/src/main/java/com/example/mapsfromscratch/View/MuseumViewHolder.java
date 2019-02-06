package com.example.mapsfromscratch.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mapsfromscratch.Fragment.FragmentInterface;
import com.example.mapsfromscratch.Fragment.MainFragment;
import com.example.mapsfromscratch.Model.MuseumObject;
import com.example.mapsfromscratch.R;

public class MuseumViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView address;
    private TextView city;
    private TextView state;
    private TextView zip;
    private CardView cardView;

    public MuseumViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        address = (TextView) itemView.findViewById(R.id.address);
        city = (TextView) itemView.findViewById(R.id.city);
        state = (TextView) itemView.findViewById(R.id.state);
        zip = (TextView) itemView.findViewById(R.id.zip);
        cardView = itemView.findViewById(R.id.cardview);

    }

    public void onBind(final MuseumObject museumObject) {
        name.setText(museumObject.getName());
        address.setText(museumObject.getAddress());
        city.setText(museumObject.getCity());
        state.setText(museumObject.getState());
        zip.setText(museumObject.getZip());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentInterface fragmentInterface = (FragmentInterface) itemView.getContext();
                fragmentInterface.startMap(museumObject);
            }
        });

    }
}
