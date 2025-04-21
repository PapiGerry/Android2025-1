package com.example.simulacroexamen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.StrictMode;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ContactAdapter contactAdapter;
    RecyclerView listContacts;

    TextView txvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txvContacts = findViewById(R.id.txvContact);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ccardoso.multics.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService serivce = retrofit.create(ContactService.class);

        Call<List<Contact>> contactCall = serivce.listContacts();
        try{

            Response<List<Contact>> response = contactCall.execute();
            List<Contact> contacts = response.body();
            assert  contacts != null;
            String x = "";
            for(Contact c: contacts){

                x += c.name + " "+ c.phone + "\n";

            }
            txvContacts.setText(x);

        } catch (IOException e){

            throw new RuntimeException(e);
        }

        listContacts = findViewById(R.id.listContacts);
        contactAdapter = new ContactAdapter();
        listContacts.setAdapter(contactAdapter);
        listContacts.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}