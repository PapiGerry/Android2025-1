package com.example.basededatos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "nombre")
    public String firstName;

    @ColumnInfo(name = "phone")
    public String lastName;
}
