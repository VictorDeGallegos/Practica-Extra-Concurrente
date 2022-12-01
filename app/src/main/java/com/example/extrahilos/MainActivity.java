package com.example.extrahilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.extrahilos.Hilos.Matriz;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText num_hilos;
    EditText edit_matriz;
    Button boton;
    TextView resultado;
    //Matrices matriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Boton para ir a segunda actividad
        Button button = findViewById(R.id.secondActivityButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            }
        });

        num_hilos = (EditText) findViewById(R.id.edit_num_hilos);
        edit_matriz = (EditText) findViewById(R.id.edit_matriz);
        boton = (Button) findViewById(R.id.ejecutar);
        resultado = (TextView) findViewById(R.id.resultado);


        boton.setOnClickListener(new View.OnClickListener() {
            // Multiplicar la matriz de forma concurrente y mostrar el tiempo en pantalla
            @Override
            public void onClick(View v) {
                int num_hilos = Integer.parseInt(MainActivity.this.num_hilos.getText().toString());
                String tam = edit_matriz.getText().toString();
                Matriz matriz = new Matriz(tam);
                long start = System.currentTimeMillis();
                matriz.multiplicaConcurrente(matriz, num_hilos);
                long end = System.currentTimeMillis();
                resultado.setText("Tiempo de ejecución: " + (end - start) + " ms");
            }
        });
    }

    public int[][] leer() throws  IOException{
        InputStream is = this.getResources().openRawResource(R.raw.mat1000);//actualicen esto, para poner cualquier archvio
        return null;
    }
}

