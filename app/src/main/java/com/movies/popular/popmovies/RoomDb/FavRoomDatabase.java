package com.movies.popular.popmovies.RoomDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.movies.popular.popmovies.model.MovieModel;


@Database(entities = {MovieModel.class}, version = 1, exportSchema = false)
public abstract class FavRoomDatabase extends RoomDatabase {

    public abstract FavouriteDao favouriteDao();

    private static volatile FavRoomDatabase INSTANCE;

    public static FavRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FavRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FavRoomDatabase.class
                            , "favo_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
