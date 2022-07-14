package com.hanynemr.yat730dbapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {
    TextView tvTitle, tvGenre;
    ImageView posterImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        tvTitle = findViewById(R.id.tvTitle);
        tvGenre = findViewById(R.id.tvGenre);
        posterImg = findViewById(R.id.posterImg);

        String title = getIntent().getStringExtra("title");
        Movie movie = MovieDatabase.getInstance(this).movieDAO().selectMovieByTitle(title);
        tvTitle.setText(movie.title);
        tvGenre.setText(movie.genre);

        Picasso.get().load(movie.poster).placeholder(R.drawable.ic_launcher_background).into(posterImg);

    }
}