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
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.movies.popular.popmovies.Constants;
import com.movies.popular.popmovies.interfaces.ListItemClickListener;
import com.movies.popular.popmovies.R;
import com.movies.popular.popmovies.model.TrailerList;
import com.movies.popular.popmovies.model.TrailerModel;
import com.squareup.picasso.Picasso;

/**
 * Created by lenovo on 2/23/2018.
 */
public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    TrailerList trailerList;
    Context context;
    final ListItemClickListener listener;

    public TrailerAdapter(TrailerList trailerList, Context context, ListItemClickListener listener) {
        this.trailerList = trailerList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_item, parent, false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (trailerList != null)
            return trailerList.getResults().size();
        else return 0;
    }

    class TrailerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView thumbnail;
        TextView movieName;
        //  , trailerType, trailerQuality;

        public TrailerViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.trailer_iv);
            movieName = itemView.findViewById(R.id.trailer_movie_name);
            //   trailerType = itemView.findViewById(R.id.trailer_type);
            //   trailerQuality = itemView.findViewById(R.id.trailer_quality);

            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            TrailerModel model = trailerList.getResults().get(position);
            movieName.setText(model.getName());
            //  trailerType.append(model.getSite());
            //  trailerQuality.append(String.valueOf(model.getSize()) + "p");
            Picasso.with(context).load(Constants.THUMBNAIL_BASE_URL + model.getKey() + "/0.jpg").into(thumbnail);
        }

        @Override
        public void onClick(View view) {
            listener.onListItemClick(getAdapterPosition());
        }
    }
}
