package com.example.extrahilos.Hilos;

public class Contador implements Runnable{
    public static  int contador = 0;
    private final int rondas = 10000;

    @Override
    public void run(){
        for(int i = 0; i < rondas; ++i){
            ++contador;
        }
    }

    public synchronized void contador(){
        for(int i = 0; i < rondas; ++i){
            ++contador;
        }
    }
    //Ejecutar el contador
    public void ejecutar() throws InterruptedException {
        Thread[] hilos = new Thread[10];
        for(int i = 0; i < hilos.length; ++i){
            hilos[i] = new Thread(new Contador());
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
    }


}
