package com.example.mapsfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mapsfromscratch.Controller.MuseumAdapter;
import com.example.mapsfromscratch.Fragment.FragmentInterface;
import com.example.mapsfromscratch.Fragment.MainFragment;
import com.example.mapsfromscratch.Maps.MapsActivity;
import com.example.mapsfromscratch.Model.MuseumList;
import com.example.mapsfromscratch.Model.MuseumObject;
import com.example.mapsfromscratch.Network.MuseumService;
import com.example.mapsfromscratch.Network.RetrofitSingleton;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment fragment = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();


    }

    @Override
    public void startMap(MuseumObject museumObject) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("name", museumObject.getName());
        intent.putExtra("address", museumObject.getAddress());
        startActivity(intent);
    }
}
