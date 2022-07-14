package com.hanynemr.yat730dbapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MovieEditActivity extends AppCompatActivity {
    EditText editTitleText, editGenreText;
    MovieDAO movieDAO;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_edit);
        editTitleText = findViewById(R.id.editTitleText);
        editGenreText = findViewById(R.id.editGenreText);

        movieDAO = MovieDatabase.getInstance(this).movieDAO();

    }

    public void insert(View view) {


        int exists = movieDAO.exists(editTitleText.getText().toString());
        if (exists > 0) {
            Toast.makeText(this, "movie exists", Toast.LENGTH_SHORT).show();
            return;
        }

        Movie movie = new Movie();
        movie.title = editTitleText.getText().toString();
        movie.genre = editGenreText.getText().toString();

        long insert = movieDAO.insert(movie);
        if (insert > 0) Toast.makeText(this, "movie saved", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Error in saving", Toast.LENGTH_SHORT).show();

    }

    public void update(View view) {
        movie.title = editTitleText.getText().toString();
        movie.genre = editGenreText.getText().toString();

        int update = movieDAO.update(movie);
        if (update > 0) Toast.makeText(this, "movie updated", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "error in update", Toast.LENGTH_SHORT).show();

    }

    public void load(View view) {

        movie = movieDAO.selectMovieByTitle(editTitleText.getText().toString());
        editGenreText.setText(movie.genre);
    }

    public void delete(View view) {
        int delete = movieDAO.delete(movie);
        if (delete > 0) Toast.makeText(this, "movie deleted", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "error in delete", Toast.LENGTH_SHORT).show();
    }
}