package com.speedofy.app.rockstarchefdemo.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseModel {
    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("results")
    private List<MovieDetailsModel> movies;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<MovieDetailsModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDetailsModel> movies) {
        this.movies = movies;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


}
