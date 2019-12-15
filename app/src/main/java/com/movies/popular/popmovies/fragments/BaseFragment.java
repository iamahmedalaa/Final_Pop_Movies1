package com.movies.popular.popmovies.fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.movies.popular.popmovies.DeatailActivity;
import com.movies.popular.popmovies.DetailFragment;
import com.movies.popular.popmovies.MainActivity;
import com.movies.popular.popmovies.R;
import com.movies.popular.popmovies.adapters.RecyclerViewAdapter;
import com.movies.popular.popmovies.interfaces.ListItemClickListener;
import com.movies.popular.popmovies.interfaces.Searchable;
import com.movies.popular.popmovies.model.MovieModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements ListItemClickListener, Searchable {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    List<MovieModel> moviesList;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        recyclerView = view.findViewById(R.id.base_rec_view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }


    public void initRecyclerView() {
        adapter = new RecyclerViewAdapter(getContext(), this);
        int column_count = getResources().getInteger(R.integer.grid_column_count);
        GridLayoutManager manager = new GridLayoutManager(getContext(), column_count);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void search(String query) {
        Toast.makeText(getContext(), "Not implemented yet",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        MovieModel model = moviesList.get(clickedItemIndex);
        Bundle bundle = new Bundle();
        bundle.putString("movie_id",model.getId());

        if (MainActivity.mTWO_PANE){
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        }else {
            Intent intent = new Intent(getActivity(), DeatailActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }



    }
}
