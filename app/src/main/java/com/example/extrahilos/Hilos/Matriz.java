package com.example.extrahilos.Hilos;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matriz {

    private final int[][] valores;

    /**
     * Función constructora
     * @param valores valores de la matríz
     * @throws IllegalArgumentException si se intenta crear una matríz
     *  que no sea de tamaño n x n (cuadrada)
     */
    public Matriz(int[][] valores)
            throws IllegalArgumentException {

        if (valores.length != valores[0].length)
            throw new IllegalArgumentException(
                    "Solo se permiten matrices de tamaño n x n"
            );

        this.valores = valores;
    }


    public Matriz(String tam) {
        int i = 0;
        int t = Integer.parseInt(tam);
        valores = new int[t][t];
        try {

            File myObj = new File("app/src/main/res/raw/mat"+tam);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(" ");
                for (int j = 0; j < temp.length; j++) {
                    valores[i][j] = Integer.parseInt(temp[j]);
                }
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




    /**
     * Multiplica la matríz con otra dada
     * @param matriz la matriz a multiplicar
     * @return el resultado de la multiplicación
     */
    public Matriz multiplica(Matriz matriz) {
        int n = valores.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += valores[i][k] * matriz.valores[k][j];
                }
            }
        }
        return new Matriz(resultado);
    }

    public Matriz multiplicaConcurrente(Matriz matriz, int num_hilos) {
        MultipliacionConcurrente mc = new MultipliacionConcurrente(this, matriz);
        List<Thread> hilosh = new ArrayList<>();
        int n = valores.length;


        try {

            for(int i = 0; i < n; i++){
                Thread t = new Thread(mc, i + "");
                hilosh.add(t);
                t.start();


                if(hilosh.size() == num_hilos){
                    for(Thread t1 : hilosh){
                        t1.join();
                    }
                    hilosh.clear();
                }
            }

            for(Thread threads: hilosh){
                threads.join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mc.resultado();
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        for (int[] valore : valores) {
            resultado.append("[ ").append(valore[0]);
            for (int j = 1; j < valores.length; j++) {
                resultado.append(", ").append(valore[j]);
            }
            resultado.append(" ]\n");
        }
        return resultado.toString();
    }



    /**
     * Clase auxiliar para la multiplicación concurrente
     * de dos matrices
     */
    static class MultipliacionConcurrente implements Runnable{
        private final Matriz a;
        private final Matriz b;
        private final Matriz c;

        public MultipliacionConcurrente(
                Matriz a,
                Matriz b
        ) {
            this.a = a;
            this.b = b;
            int n = a.valores.length;
            this.c = new Matriz(new int[n][n]);
        }

        @Override
        public void run() {
            String celda = Thread.currentThread().getName();
            calculaCelda(Integer.parseInt(celda));
        }

        public void calculaCelda(int fila) {
            int n = a.valores.length;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c.valores[fila][j] += a.valores[fila][k] * b.valores[k][j];
                }
            }
        }

        public Matriz resultado() {
            return c;
        }
    }
}