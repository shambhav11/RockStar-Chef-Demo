package com.speedofy.app.rockstarchefdemo.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.speedofy.app.rockstarchefdemo.R;
import com.speedofy.app.rockstarchefdemo.data.home.HomeRepository;
import com.speedofy.app.rockstarchefdemo.data.models.MovieDetailsModel;
import com.speedofy.app.rockstarchefdemo.ui.details.DetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {


    private static List<MovieDetailsModel> movieDetailsModelList;
    Context context;

    public MovieListAdapter(List<MovieDetailsModel> movieDetailsModels,Context context)
    {
        this.movieDetailsModelList=movieDetailsModels;
        this.context=context;
    }

    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(i,viewGroup,false);

        return new MovieListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder viewHolder, int i){
        viewHolder.bindData(movieDetailsModelList.get(i));
    }
    public void updateList(List<MovieDetailsModel> list){
        this.movieDetailsModelList = list;
        notifyDataSetChanged();
    }

    public List<MovieDetailsModel> getMovieDetailsModelList() {
        return movieDetailsModelList;
    }



    @Override
    public int getItemViewType(final int position){
        return R.layout.item_movielist;
    }


    @Override
    public int getItemCount(){
        return movieDetailsModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
        @BindView(R.id.image)
        ImageView imageView;
        @BindView(R.id.movie_name)
        TextView movieName;
        @BindView(R.id.movie_rating)
        TextView movieRating;





        void bindData(final MovieDetailsModel classT) {
            movieName.setText(classT.getTitle());
            movieRating.setText(String.valueOf(classT.getVoteAverage()));
            Glide.with(context).load("https://image.tmdb.org/t/p/w500"+classT.getPosterPath()).into(imageView);
            imageView.setAdjustViewBounds(true);

            movieName.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, DetailsActivity.class);
                    intent.putExtra("Object",classT);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

    }
}
