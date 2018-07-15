package com.example.sakshi.classapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.networkutil.NetworkUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;

    String id;

    String data;

    String API_KEY ="ccf5ee90fced49989229f81e34fdd1be";
    String URL ="https://newsapi.org/v2/top-headlines?sources=";

    ProgressBar progressBar3;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView =findViewById(R.id.detailList);


        progressBar3 = findViewById(R.id.progressBar3);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();

        id = intent.getStringExtra("id");

        adapter =new Adapter(this);
        recyclerView.setAdapter(adapter);

        new FetchNews().execute();



    }

    class FetchNews extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar3.setVisibility(View.VISIBLE);
        }


        @Override
        protected Void doInBackground(Void... voids) {

            String finalUrl =URL+id+"&apiKey=ccf5ee90fced49989229f81e34fdd1be";

            data = NetworkUtil.makeServiceCall(finalUrl);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            ArrayList<News> newsArrayList = new ArrayList<>();

            progressBar3.setVisibility(View.INVISIBLE);

            if (data==null){
                Toast.makeText(Main2Activity.this, "No data returned", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    JSONObject jasonData =new JSONObject(data);
                    JSONArray articleArray =jasonData.getJSONArray("articles");

                    for(int i=0;i<articleArray.length();i++){
                        JSONObject news = articleArray.getJSONObject(i);
                        String title = news.getString("title");
                        String description = news.getString("description");
                        String imageURl = news.getString("urlToImage");

                        newsArrayList.add(new News(title,description,imageURl));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            adapter.swap(newsArrayList);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            progressBar3.setProgress(0);

        }
    }
}
