package com.example.sakshi.classapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ItemClick {


    String[] channelId ={"abc-news","national-geographic","the-times-of-india","espn","cnn"};

    RecyclerView recyclerView;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.channerRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CustomAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void newClick(int position) {
        String Chid =channelId[position];
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("id",Chid);
        startActivity(intent);
    }
}
