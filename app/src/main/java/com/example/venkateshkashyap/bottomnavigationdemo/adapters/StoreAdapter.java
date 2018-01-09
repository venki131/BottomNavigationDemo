package com.example.venkateshkashyap.bottomnavigationdemo.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.venkateshkashyap.bottomnavigationdemo.R;
import com.example.venkateshkashyap.bottomnavigationdemo.models.Movie;

import java.util.List;

/**
 * Created by Venkatesh Kashyap on 1/9/2018.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private Context context;
    private List<Movie> movieList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = movieList.get(position);
        holder.name.setText(movie.getTitle());
        holder.price.setText(movie.getPrice());

        Glide.with(context)
                .load(movie.getImage())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, price;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
    public StoreAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }


}
