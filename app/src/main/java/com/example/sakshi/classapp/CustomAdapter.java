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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    String[] channelName ={"ABC NEWS","TIMES OF INDIA","NATIONAL GEOGRAPHIC","ESPN","CNN"};
    String[] channelType = {"Media company","Newspaper","Cable network","Cable company","Media company"};

    Context context;

    ItemClick itemClick;

    public CustomAdapter(Context context) {
        this.context = context;
        itemClick =(ItemClick)context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, final int position) {

        holder.channerTitle.setText(channelName[position]);
        holder.channerType.setText(channelType[position]);

        holder.channerTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.newClick(position);
            }
        });

        switch (position){
            case 0:
                Glide.with(context).load(R.drawable.abc).into(holder.imageView);
                break;

            case 1:
                Glide.with(context).load(R.drawable.toi).into(holder.imageView);
                break;
            case 2:
                Glide.with(context).load(R.drawable.national).into(holder.imageView);
                break;
            case 3:
                Glide.with(context).load(R.drawable.espn).into(holder.imageView);
                break;
            case 4:
                Glide.with(context).load(R.drawable.newscnn).into(holder.imageView);
                break;

        }


    }

    @Override
    public int getItemCount() {
        return channelName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView channerTitle,channerType;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);


            channerTitle = itemView.findViewById(R.id.abcTextView);
            channerType = itemView.findViewById(R.id.typeTextView);

            imageView = itemView.findViewById(R.id.abcImageView);
        }
    }
}
