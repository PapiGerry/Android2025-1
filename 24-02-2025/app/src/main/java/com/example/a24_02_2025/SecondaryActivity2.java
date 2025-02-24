package com.example.a24_02_2025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondaryActivity2 extends AppCompatActivity {

    TextView txvTitle;
    Button btnContinuar;

    ViewModel vm = new ViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondary2);

        txvTitle = findViewById(R.id.txvTitle);
        btnContinuar = findViewById(R.id.btnContinuar);
        txvTitle.setText(R.string.actividad_dos);

        btnContinuar.setOnClickListener(v -> {

            vm.navigate(this, TercerActivity.class);

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}