package com.example.a24_02_2025;

import android.content.Context;
import android.content.Intent;

public abstract class ViewModelNavigable{

    public void navigate(Context context, Class actividad){

        Intent i = new Intent(context, actividad);
        context.startActivity(i);

    }
}
