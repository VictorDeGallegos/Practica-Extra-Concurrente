package com.example.extrahilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.extrahilos.Hilos.Contador;

public class SecondActivity extends AppCompatActivity {
    TextView resultado2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resultado2 = (TextView) findViewById(R.id.resultado2);
        Contador contador = new Contador();
        try {
            contador.ejecutar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultado2.setText("El contador vale: " + Contador.contador);
    }



}