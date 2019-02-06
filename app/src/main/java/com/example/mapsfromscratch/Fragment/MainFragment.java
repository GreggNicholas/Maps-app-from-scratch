package com.example.mapsfromscratch.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mapsfromscratch.Controller.MuseumAdapter;
import com.example.mapsfromscratch.Model.MuseumList;
import com.example.mapsfromscratch.Model.MuseumObject;
import com.example.mapsfromscratch.Network.MuseumService;
import com.example.mapsfromscratch.Network.RetrofitSingleton;
import com.example.mapsfromscratch.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainFragment extends Fragment {
    private static final String TAG = "tag";
    private RecyclerView recyclerView;




    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = rootview.findViewById(R.id.recyclerview);
        Retrofit instance = RetrofitSingleton.getInstance();
        MuseumService museumService = instance.create(MuseumService.class);
        Call<MuseumList> museumListCall = museumService.getMuseumObject();
        museumListCall
                .enqueue(new Callback<MuseumList>() {
                    @Override
                    public void onResponse(Call<MuseumList> call, Response<MuseumList> response) {
                        Log.d(TAG, "onResponse: " + response.body().getMuseumList().get(0).getName());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(new MuseumAdapter(response.body().getMuseumList()));

                    }

                    @Override
                    public void onFailure(Call<MuseumList> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
        return rootview;
    }

}
