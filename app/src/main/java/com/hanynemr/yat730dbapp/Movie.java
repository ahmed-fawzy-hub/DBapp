package com.hanynemr.yat730dbapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title, genre, poster;

    public int authorID;

}
