package com.speedofy.app.rockstarchefdemo.data.interfaces;

import com.speedofy.app.rockstarchefdemo.data.models.MovieDetailsModel;

import java.util.List;

public interface onGetListCallback {

    void onSuccess(List<MovieDetailsModel> movies);

    void onError();

}
