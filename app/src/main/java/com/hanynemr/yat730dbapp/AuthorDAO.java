package com.hanynemr.yat730dbapp;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AuthorDAO {

    //tuple
    @Query("select * from authormovie")
    List<AuthorMovie> selectAuthorMovies();

}
