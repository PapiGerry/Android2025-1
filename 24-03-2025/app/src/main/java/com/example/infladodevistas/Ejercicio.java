package com.example.infladodevistas;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio extends AppCompatActivity {

    Button btnAgrega;
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        root = findViewById(R.id.lytMain);
        btnAgrega = findViewById(R.id.btnAgrega);
        btnAgrega.setOnClickListener(v ->{
            sumaNumeroIzq();
            sumaNumeroDer();

        });

    }

     void sumaNumeroIzq(){

         LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
         Button btnNumero = new Button(this);

         btnNumero.setMinimumWidth(100);
         btnNumero.setMinimumWidth(100);

         lytItemPrueba.setGravity(Gravity.LEFT);
         lytItemPrueba.addView(btnAgrega);


         root.addView(lytItemPrueba);

         lytItemPrueba.setMinimumHeight(MATCH_PARENT);
         lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));


     }

     void sumaNumeroDer(){

         LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
         Button btnNumero = new Button(this);

         btnNumero.setMinimumWidth(100);
         btnNumero.setMinimumWidth(100);

         lytItemPrueba.setGravity(Gravity.RIGHT);
         lytItemPrueba.addView(btnAgrega);


         root.addView(lytItemPrueba);

         lytItemPrueba.setMinimumHeight(MATCH_PARENT);
         lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));


     }
}
