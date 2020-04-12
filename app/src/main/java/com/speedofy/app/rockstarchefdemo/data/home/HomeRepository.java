package com.speedofy.app.rockstarchefdemo.data.home;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.speedofy.app.rockstarchefdemo.RetrofitClientInstance;
import com.speedofy.app.rockstarchefdemo.data.interfaces.ApiCall;
import com.speedofy.app.rockstarchefdemo.data.interfaces.onGetListCallback;
import com.speedofy.app.rockstarchefdemo.data.models.APIResponseModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    public int pageNum;

    static HomeRepository mRepository;

     ApiCall apiCall;

     public HomeRepository(ApiCall apiCall)
     {
         this.apiCall=apiCall;
         pageNum=1;

     }

     public static HomeRepository getInstance()
     {
         if (mRepository == null) {
             mRepository = new HomeRepository(RetrofitClientInstance.getRetrofitInstance().create(ApiCall.class));
         }
         return mRepository;
     }

    public void getList(final onGetListCallback callback) {
        apiCall.getPopularMovies("4e8ed1461a85fb27fc448d984e24794c", pageNum)
                .enqueue(new Callback<APIResponseModel>() {
                    @Override
                    public void onResponse(@NonNull Call<APIResponseModel> call, @NonNull Response<APIResponseModel> response) {
                        if (response.isSuccessful()) {
                            APIResponseModel moviesResponse = response.body();
                            if (moviesResponse != null && moviesResponse.getMovies() != null) {
                                callback.onSuccess(moviesResponse.getMovies());
                                pageNum++;
                            } else {
                                callback.onError();
                            }
                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Log.e("HomeRepo",jObjError.getJSONObject("error").getString("message"));                            } catch (Exception e) {
                            }
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<APIResponseModel> call, Throwable t) {

                        callback.onError();
                    }
                });
    }



}
