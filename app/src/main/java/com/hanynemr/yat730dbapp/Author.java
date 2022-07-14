package com.hanynemr.yat730dbapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "authors")
public class Author {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
}
