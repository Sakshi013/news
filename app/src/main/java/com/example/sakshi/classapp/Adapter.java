package com.example.sakshi.classapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


   ArrayList<News>newsList;
   Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listiteam,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return newsList ==null?0 : newsList.size();
    }

    public void swap(ArrayList<News> newsArrayList) {

        this .newsList =newsArrayList;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv,descriptionTv;
        ImageView newsImage;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTv =itemView.findViewById(R.id.tittleTextview);
            descriptionTv=itemView.findViewById(R.id.descTextView);
            newsImage = itemView.findViewById(R.id.newsImage);
        }

        public void bind(int position) {

            titleTv.setText(newsList.get(position).getTitle());
            descriptionTv.setText(newsList.get(position).getDescription());

            Glide.with(context).load(newsList.get(position).getImgURL()).into(newsImage);



        }
    }
}
