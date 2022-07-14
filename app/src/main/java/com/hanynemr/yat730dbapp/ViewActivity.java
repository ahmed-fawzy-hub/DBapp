package com.hanynemr.yat730dbapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        list = findViewById(R.id.list);

        String from = getIntent().getStringExtra("from");
        if (from.equals("movies")) {
            List<Movie> movies = MovieDatabase.getInstance(this).movieDAO().selectAllMovies();

            MovieAdapter adapter = new MovieAdapter(this, movies);
            list.setAdapter(adapter);
        } else if (from.equals("authors")) {
            List<AuthorMovie> authorMovies = MovieDatabase.getInstance(this).authorDAO().selectAuthorMovies();
            //show data
        }

    }

    class MovieAdapter extends ArrayAdapter<Movie> {

        public MovieAdapter(@NonNull Context context, List<Movie> movies) {
            super(context, 0, movies);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.custom_movie, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();

            }

            holder.cm_title.setText(getItem(position).title);
            Picasso.get().load(getItem(position).poster).into(holder.cm_image);

            return convertView;

        }

        class ViewHolder {
            TextView cm_title;
            ImageView cm_image;

            public ViewHolder(View convertView) {
                cm_title = convertView.findViewById(R.id.cm_title);
                cm_image = convertView.findViewById(R.id.cm_image);
            }
        }
    }

}