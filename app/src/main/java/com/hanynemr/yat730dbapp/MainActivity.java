package com.hanynemr.yat730dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Spinner genreSpinner;
    List<String> genres;
    ListView lvTtitles;
    List<String> title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genreSpinner = findViewById(R.id.genreSpinner);
        lvTtitles = findViewById(R.id.lvTitles);


        genres = MovieDatabase.getInstance(this).movieDAO().selectGenre();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, genres);
        genreSpinner.setAdapter(adapter);

        genreSpinner.setOnItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String genre=genreSpinner.getSelectedItem().toString();

        String genre = genres.get(position);

        title = MovieDatabase.getInstance(this).movieDAO().selectTitleByGenre(genre);
//        ArrayAdapter ad
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, title);
        lvTtitles.setAdapter(adapter);

        lvTtitles.setOnItemClickListener(this);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String t = title.get(position);
        Intent in = new Intent(this, MovieDetailActivity.class);
        in.putExtra("title", t);
        startActivity(in);


    }

    public void allMovies(MenuItem item) {
        Intent in = new Intent(this, ViewActivity.class);
        in.putExtra("from", "movies");
        startActivity(in);

    }

    public void allAuthors(MenuItem item) {
        Intent in = new Intent(this, ViewActivity.class);
        in.putExtra("from", "authors");
        startActivity(in);
    }
}