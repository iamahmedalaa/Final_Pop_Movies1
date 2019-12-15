/*
 * This project was submitted by Mohamed Ali as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * You could use the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018 Mohamed Ali
 *
 * Besides the above notice, the following license applies and this license notice
 * must be included in all works derived from this project.
 *
 *
 * MIT License
 *
 * Copyright (c) 2018 Mohamed Ali
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.movies.popular.popmovies.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.movies.popular.popmovies.Constants;
import com.movies.popular.popmovies.interfaces.ListItemClickListener;
import com.movies.popular.popmovies.model.MovieModel;
import com.movies.popular.popmovies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo on 2/19/2018.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderOne> {

    Context context;
    ListItemClickListener listener;
    List<MovieModel> movieModels;

    public RecyclerViewAdapter(Context context, ListItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }


    @Override
    public RecyclerViewAdapter.ViewHolderOne onCreateViewHolder(ViewGroup parent, int viewType) {

        final RecyclerViewAdapter.ViewHolderOne holder;
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_1, parent, false);
        holder = new ViewHolderOne(view);
        return holder;

    }

    // https://www.youtube.com/watch?v=blwB8GL4vWw
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolderOne holder, int position) {
        holder.bind(position);

    }



    @Override
    public int getItemCount() {
        if (movieModels != null) return movieModels.size();
        else return 0;
    }

    public void setList(List<MovieModel> movieModels){
        this.movieModels = movieModels;
    }


    class ViewHolderOne extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textview;
        ImageView imageView;

        public ViewHolderOne(View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.movie_title);
            imageView = itemView.findViewById(R.id.movie_image_view);

            itemView.setOnClickListener(this);

        }

        void bind(int position) {
            MovieModel model = movieModels.get(position);
            textview.setText(model.getTitle());
            String imageUrl = Constants.IMAGE_BASE_URL + model.getPoster_path();
            Picasso.with(context).load(imageUrl).into(imageView);
        }

        @Override
        public void onClick(View view) {
            listener.onListItemClick(getAdapterPosition());
        }
    }



}