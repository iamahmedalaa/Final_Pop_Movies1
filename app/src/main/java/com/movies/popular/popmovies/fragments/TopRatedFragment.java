package com.movies.popular.popmovies.fragments;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Toast;
import com.movies.popular.popmovies.model.MovieModel;
import com.movies.popular.popmovies.topRated.TopRatedViewModel;
import com.movies.popular.popmovies.utility.NetworkUtility;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedFragment extends BaseFragment {

    TopRatedViewModel topRatedViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
        if (NetworkUtility.getNetworkState(getContext()).isNetworkAvailable()) {
            topRatedViewModel = ViewModelProviders.of(this).get(TopRatedViewModel.class);
            try {
                topRatedViewModel.getLiveData().observe(this, new Observer<List<MovieModel>>() {
                    @Override
                    public void onChanged(@Nullable List<MovieModel> movieModels) {
                        if (movieModels != null) {
                            adapter.setList(movieModels);
                            adapter.notifyDataSetChanged();
                            moviesList = movieModels;

                        }
                    }
                });
            } catch (Exception e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Check your network connection!", Toast.LENGTH_SHORT).show();
        }

    }


}
