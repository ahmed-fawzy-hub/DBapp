package com.hanynemr.yat730dbapp;


import androidx.room.DatabaseView;

@DatabaseView("SELECT title,name from movies INNER JOIN authors on movies.authorID=authors.id")
public class AuthorMovie {

    public String title, name;
}
