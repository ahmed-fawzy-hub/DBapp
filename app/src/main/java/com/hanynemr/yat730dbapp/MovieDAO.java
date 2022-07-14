package com.hanynemr.yat730dbapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDAO {

    @Query("SELECT distinct genre FROM movies order by genre")
    List<String> selectGenre();

    @Query("SELECT title from movies WHERE genre=:genre")
    List<String> selectTitleByGenre(String genre);

    @Query("SELECT * FROM movies WHERE title=:title")
    Movie selectMovieByTitle(String title);

    @Query("SELECT * FROM movies order by title")
    List<Movie> selectAllMovies();

    @Insert
    long insert(Movie movie);

    @Query("select id FROM movies WHERE title=:title limit 1")
    int exists(String title);

    @Update
    int update(Movie movie);

    @Delete
    int delete(Movie movie);
}
