package com.speedofy.app.rockstarchefdemo.data.interfaces;

import com.speedofy.app.rockstarchefdemo.data.models.APIResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {
    @GET("discover/movie")
    Call<APIResponseModel> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );
}
