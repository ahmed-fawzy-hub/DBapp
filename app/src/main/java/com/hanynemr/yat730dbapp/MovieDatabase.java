package com.hanynemr.yat730dbapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class, Author.class}, views = {AuthorMovie.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase ourInstance;

    public static MovieDatabase getInstance(Context context) {

        if (ourInstance == null) {

            ourInstance = Room.databaseBuilder(context,

                            MovieDatabase.class, "Movies.db")
                    .createFromAsset("databases/Movies.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return ourInstance;

    }

    public abstract MovieDAO movieDAO();

    public abstract AuthorDAO authorDAO();
}
