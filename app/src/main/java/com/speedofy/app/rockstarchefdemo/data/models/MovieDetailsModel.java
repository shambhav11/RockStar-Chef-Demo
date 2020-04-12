package com.speedofy.app.rockstarchefdemo.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieDetailsModel implements Serializable {


    @SerializedName("id")
    private int id;

    @SerializedName("vote_average")

    private  double voteAverage;
    @SerializedName("vote_count")

    private int voteCount;
    @SerializedName("original_title")

    private String originalTitle;
    @SerializedName("title")

    private String title;
    @SerializedName("popularity")

    private double popularity;
    @SerializedName("backdrop_path")

    private String backdropPath;
    @SerializedName("overview")

    private String overview;
    @SerializedName("release_date")

    private String releaseDate;
    @SerializedName("poster_path")

    private String posterPath;
    @SerializedName("genre_ids")
    private List<Integer> genreList;


    public MovieDetailsModel(Integer id, Integer voteAverage, Integer voteCount, String originalTitle, String title, Double popularity, String backdropPath, String overview, String releaseDate, String posterPath,List<Integer> genreList) {
            this.id=id;
        this.voteAverage=voteAverage;
        this.voteCount=voteCount;
        this.originalTitle=originalTitle;
        this.title=title;
        this.popularity=popularity;
        this.backdropPath=backdropPath;
        this.overview=overview;
        this.releaseDate=releaseDate;
        this.posterPath=posterPath;
        this.genreList=genreList;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<Integer> getGenreList() {
        return genreList;
    }

    public void setPosterPath(List<Integer> genreList) {
        this.genreList = genreList;
    }


}
