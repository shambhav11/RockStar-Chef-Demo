package com.speedofy.app.rockstarchefdemo.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.speedofy.app.rockstarchefdemo.R;
import com.speedofy.app.rockstarchefdemo.data.home.HomeRepository;
import com.speedofy.app.rockstarchefdemo.data.interfaces.onGetListCallback;
import com.speedofy.app.rockstarchefdemo.data.models.MovieDetailsModel;
import com.speedofy.app.rockstarchefdemo.sessionmanager.SessionManager;
import com.speedofy.app.rockstarchefdemo.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    private MovieListAdapter mAdapter;
    private HomeRepository mRepository;
    List<MovieDetailsModel> movieDetailsModels;
    @BindView(R.id.right_drawer_open)
    ImageView searchIcon;
    @BindView(R.id.search_bar)
    EditText searchBar;
    @BindView(R.id.indeterminateBar)
    ProgressBar progressBar;
    @BindView(R.id.movieList)
    RecyclerView recyclerView;
    @BindView(R.id.loadmore)
    Button loadmore;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        mRepository = HomeRepository.getInstance();
        mRepository.getList(new onGetListCallback() {
            @Override
            public void onSuccess(List<MovieDetailsModel> movies) {
                movieDetailsModels = movies;
                mAdapter = new MovieListAdapter(movies, getApplicationContext());
                recyclerView.setAdapter(mAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "Error in Loading list", Toast.LENGTH_LONG).show();
            }
        });


    }

    @OnClick(R.id.right_drawer_open)
    public void search() {
        if (searchBar.getVisibility() == View.VISIBLE) {
            searchBar.setVisibility(View.GONE);
            loadmore.setVisibility(View.VISIBLE);
        } else {
            searchBar.setVisibility(View.VISIBLE);
            loadmore.setVisibility(View.GONE);
        }
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });
    }

    void filter(String text) {
        List<MovieDetailsModel> temp = new ArrayList<>();
        for (MovieDetailsModel d : movieDetailsModels) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getTitle().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        }
        //update recyclerview
        mAdapter.updateList(temp);
    }


    @OnClick(R.id.loadmore)
    public void addList() {
        progressBar.setVisibility(View.VISIBLE);
        mRepository.getList(new onGetListCallback() {
            @Override
            public void onSuccess(List<MovieDetailsModel> movies) {
                movieDetailsModels.addAll(movies);
                mAdapter.updateList(movieDetailsModels);
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "Error in Loading list", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_logOut) {
            SessionManager.setLoggedIn(getApplicationContext(), false);


            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
        return true;
    }
}

