package com.example.basededatos;

import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;
import java.util.Random;

public class Repositorio {

    private String databaseName = "database.zeus"
    private DataBaseOperation handler;

    private AppDatabase db = null;

    public Repositorio(DatabaseOperation handler){

        this.handler = handler;
        AsyncTask.execute(() -> {

            this.db = Room.databaseBuilder(
                    getApplicationContext(),
                    AppDatabase.class, databaseName

            ).build();
        });
    }



    interface OnUserDBSave{

        void  onSavedUser(User user);
        void onDelete();
        void onList(List<User> users);
    }

    public void listUsers(){

        AsyncTask.execute(() -> {

            UserDao userDao = db.userDao();
            List<User> users = userDao.getAll();
            return handler.onList(users);

        });
    }

    public void createUser(User user){

        AsyncTask.execute(() -> {

            UserDao userDao = db.userDao();
            userDao.insert(user);
            return handler.onSaved(users);

        });
    }


}

