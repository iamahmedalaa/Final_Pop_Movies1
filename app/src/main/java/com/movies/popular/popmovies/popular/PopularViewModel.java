package com.movies.popular.popmovies.popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.movies.popular.popmovies.model.MovieModel;

import java.util.List;

public class PopularViewModel extends ViewModel {


    LiveData<List<MovieModel>> listLiveData;

    PopularRepository popularRepository;


    public LiveData<List<MovieModel>> getLiveData() {
        if (popularRepository == null) {
            popularRepository = new PopularRepository();
            listLiveData = popularRepository.getPopularMovies();
        }
        return listLiveData;
    }

}
