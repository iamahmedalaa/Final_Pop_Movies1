///*
// * This project was submitted by Mohamed Ali as part of the Nanodegree At Udacity.
// *
// * As part of Udacity Honor code, your submissions must be your own work, hence
// * submitting this project as yours will cause you to break the Udacity Honor Code
// * and the suspension of your account.
// *
// * You could use the code as a reference, but if
// * you submit it, it's your own responsibility if you get expelled.
// *
// * Copyright (c) 2018 Mohamed Ali
// *
// * Besides the above notice, the following license applies and this license notice
// * must be included in all works derived from this project.
// *
// *
// * MIT License
// *
// * Copyright (c) 2018 Mohamed Ali
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy
// * of this software and associated documentation files (the "Software"), to deal
// * in the Software without restriction, including without limitation the rights
// * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// * copies of the Software, and to permit persons to whom the Software is
// * furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all
// * copies or substantial portions of the Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// * SOFTWARE.
// */
//
//package com.movies.popular.popmovies.popular;
//
//import android.arch.paging.PageKeyedDataSource;
//import android.support.annotation.NonNull;
//
//import com.movies.popular.popmovies.Constants;
//import com.movies.popular.popmovies.api.ApiClient;
//import com.movies.popular.popmovies.api.ApiInterface;
//import com.movies.popular.popmovies.model.MovieList;
//import com.movies.popular.popmovies.model.MovieModel;
//
//import java.io.IOException;
//import retrofit2.Response;
//
///**
// * Created by lenovo on 2/20/2018.
// */
//
//public class PopularDataSource extends PageKeyedDataSource<Integer, MovieModel> {
//    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//
//    @Override
//    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, MovieModel> callback) {
//        try {
//            Response<MovieList> response = apiInterface.getPopularMovies(Constants.API_KEY, 1).execute();
//            if (response.isSuccessful()) {
//                callback.onResult(response.body().getResults(), 1, 2);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, MovieModel> callback) {
//
//        try {
//            Response<MovieList> response = apiInterface.getPopularMovies(Constants.API_KEY, params.key).execute();
//            if (response.isSuccessful()) {
//                callback.onResult(response.body().getResults(), params.key + 1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Override
//    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, MovieModel> callback) {
////
////        try {
////            Response<MovieList> response = apiInterface.getPopularMovies(Constants.API_KEY, params.key).execute();
////            if (response.isSuccessful()) {
////                int adjacentKey = 0;
////                if (params.key > 1)
////                    adjacentKey = params.key - 1;
////                else
////                    adjacentKey = 0 ;
////
////                    callback.onResult(response.body().getResults(), adjacentKey);
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//    }
//}
