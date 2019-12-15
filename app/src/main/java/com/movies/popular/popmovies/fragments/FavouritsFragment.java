package com.movies.popular.popmovies.fragments;


import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.movies.popular.popmovies.model.MovieModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritsFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    List<MovieModel> movieModels = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
        getActivity().getLoaderManager().initLoader(1, null, this).forceLoad();


    }

    @Override
    public void search(String query) {
        // do nothing
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new FavoriteTask(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        movieModels.clear();
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getLoaderManager().restartLoader(1, null, this).forceLoad();
    }

    private static class FavoriteTask extends AsyncTaskLoader<Cursor> {

        public FavoriteTask(Context context) {
            super(context);
        }

        @Override
        public Cursor loadInBackground() {
            return null;
        }
    }

}
