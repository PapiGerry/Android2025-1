package com.example.infladodevistas;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAgrega;

    LinearLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        root = findViewById(R.id.lytMain);
        btnAgrega = findViewById(R.id.btnAgrega);
        btnAgrega.setOnClickListener(v ->{
           generaImagen1();
        });

        btnAgrega.setOnClickListener(v ->{
            generaImagen2();
        });

    }

    void generaImagen1(){


        //Aquí se genera el inflado de vista
        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        ImageView img = new ImageView(this);

        //Aquí se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);

        //Aqui se agrega la imagen al layout inflado
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);

        //Aquí se agrega el layout inflado a la vista view
        root.addView(lytItemPrueba);

        lytItemPrueba.setMinimumHeight(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));
    }

    void generaImagen2(){

        //Aquí se genera el inflado de vista
        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        ImageView img = new ImageView(this);

        //Aquí se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);

        //Aqui se agrega la imagen al layout inflado
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);

        //Aquí se agrega el layout inflado a la vista view
        root.addView(lytItemPrueba);

        lytItemPrueba.setMinimumHeight(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));


    }
}