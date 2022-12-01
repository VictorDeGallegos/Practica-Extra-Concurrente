# Practica Extra: Android con Hilos

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Status badge](https://img.shields.io/badge/status-%20terminado-green?style=for-the-badge)

## Computacion concurrente, Universidad Nacional Autónoma de México semestre 2023-1

> ---
>
> * **Victor Hugo Gallegos Mota** - *316160456* - [VictorDeGallegos](https://github.com/VictorDeGallegos)
> * **José Demian Jiménez** - *314291707* - [demian35](https://github.com/demian35)
> * **Carlos Cruz Rangel** - *314208682* - [CarlosCruzRangel](https://github.com/CarlosCruzRangel)
> * **Ernesto Muñoz Nieves** - *314133586* - [ernt](https://github.com/ernt)
> * **Juan Carlos Bautista Sandoval** - *314275541* - [JuanBautistta](https://github.com/JuanBautistta)
>
>
>
> ---

## Pre-requisitos 📋

*Para poder ejecutar las aplicaciones es necesario tener instalado el IDE de Android Studio*

## Ejecutar scripts 🚀

Desarrollamos la practica en el IDE [AndroidStudio](https://developer.android.com/studio), por lo que se recomienda utilizarlo para probar la aplicación.

Basta con clonar el repo, o descargar el zip de https://github.com/VictorDeGallegos/Computacion-Concurrente.git

## 1.- Implementación de Multiplicación de Matrices Secuenciales y Paralelo

Para el primer ejercicio se desea implementar una multiplicación de matrices en tiempo
secuencial y paralelo (la misma utilizada en la practica 2).
El objetivo de esta actividad es ver su funcionamiento de los hilos en distintas arquitecturas (en este caso se espera que se ejecute directamente sobre un celular ARM, en caso de no poder se ejecutara sobre su computadora).
El codigo usado para esta app en Android esta básado en Java, por lo que estarian reciclando la
practica 2 en este ejercicio.

### Ejemplos de capturas en ejecución con 1, 10, 100 y 1000 hilos
<img width="250" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204950342-4c9da093-a188-419a-9912-cfd11c193180.png"> <img width="250" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204950005-a4e3e812-5c52-4d9f-ac34-6247fb5576d6.png"> <img width="250" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204950631-a757224d-5cdb-408f-a034-8bd0f0237411.png"> <img width="250" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204951272-8abc0d18-ffb9-41fe-b6f0-b37987098fad.png">

## Uso del contador sobre Android

En esta sección, el objetivo es crear una app nueva, el unico objetivo es ejecutar el contador que se
encuentra en el paquete de Hilos y mostrar los valores que se van dando, se tiene que poder seleccionar
si va a ser synchronized o no, y finalmente mostrar en un TextView el valor dado.
Es totalmente libre esta implementación, pueden utilizar un número fijo de Hilos (mayor a 1) y el
número de rondas igual puede ser fijo o no, es decir, el usuario lo puede seleccionar o no.

### Ejemplos de capturas en ejecución con 10 hilos fijos
<img width="250" alt="inicio" src="https://user-images.githubusercontent.com/41756950/204951027-c7e69136-76cb-4b2d-bae2-b84cce56f14c.png">


---
⌨️ con ❤️ por  [VictorDeGallegos](https://github.com/VictorDeGallegos), [demian35](https://github.com/demian35), [ernt](https://github.com/ernt), [CarlosCruzRangel](https://github.com/CarlosCruzRangel) y [JuanBautistta](https://github.com/JuanBautistta)