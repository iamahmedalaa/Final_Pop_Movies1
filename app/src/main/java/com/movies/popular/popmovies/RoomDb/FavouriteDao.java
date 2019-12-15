package com.movies.popular.popmovies.RoomDb;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.movies.popular.popmovies.model.MovieModel;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Insert
    void insert(MovieModel favourite);

    @Query("SELECT * FROM fav_table")
    LiveData<List<MovieModel>>getAllMovies();

    @Delete
    void deleteMovie(MovieModel favourite);

    @Query("SELECT favId FROM fav_table WHERE favId = :id")
    LiveData<String> loadMovieById(String id);




}
