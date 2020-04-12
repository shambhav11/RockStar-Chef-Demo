package com.speedofy.app.rockstarchefdemo.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.speedofy.app.rockstarchefdemo.R;
import com.speedofy.app.rockstarchefdemo.data.GenresEnum;
import com.speedofy.app.rockstarchefdemo.data.models.MovieDetailsModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.frame_image)
    FrameLayout layout;
    @BindView(R.id.imageview)
    ImageView posterImage;
    @BindView(R.id.movie_name)
    TextView movieName;
    @BindView(R.id.popularity)
    TextView popularity;
    @BindView(R.id.movie_rating)
    TextView movieRating;
    @BindView(R.id.genre_list)
    TextView genres;
    @BindView(R.id.overview_text)
    TextView Overview;
    @BindView(R.id.overview_changetext)
    TextView overviewText;
    @BindView(R.id.releaseText)
    TextView releaseText;
    @BindView(R.id.releasedate)
    TextView releaseDate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        MovieDetailsModel model= (MovieDetailsModel) intent.getSerializableExtra("Object");
        Toast.makeText(getApplicationContext(),model.getTitle(),Toast.LENGTH_LONG).show();
        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500"+model.getPosterPath()).into(posterImage);
        movieName.setText(model.getTitle());
        movieRating.setText("Rating: "+model.getVoteAverage()+"("+model.getVoteCount()+")");
        popularity.setText("Popularity: " +model.getPopularity());
        overviewText.setText(model.getOverview());
        releaseDate.setText(model.getReleaseDate());
        StringBuilder stringBuilder=new StringBuilder();


        for(int i : model.getGenreList())
        {
            stringBuilder.append(GenresEnum.valueOf(i)).append(",");

        }
        genres.setText(stringBuilder.toString().substring(0,stringBuilder.lastIndexOf(",")));




    }
}
