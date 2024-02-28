package com.teatro;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //variables
        String asientos[][] = new String[10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila=0, asiento=0;
        String respuesta;
        String vermapa;

//matriz de asientos
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                asientos[f][c] = String.valueOf('L');
            }
        }

        //msn bienvenida
        System.out.println("--------------bienvenido al sistema de reservas------------");
//sistema de reserva
        while (bandera != true) {
            //visualizacion del mapa
            System.out.println("¿Deseas ver los asientos disponibles? S:Si, Cualquier letra:No");
            vermapa = teclado.next();
            if (vermapa.equalsIgnoreCase("S")) {
                dibujar(asientos);
            }
            //reserva
            boolean franja = false;

            while (franja != true) {
                System.out.println("\n ingrese fila y asiento a reservar");
                System.out.print("fila (entre 0 y 9): ");
                fila = teclado.nextInt();

                System.out.print("asiento (entre 0 y 9): ");
                asiento = teclado.nextInt();

                if (fila >= 0 && fila <= 9) {
                    if (asiento >= 0 && asiento <= 9) {
                        franja = true;
                    } else {
                        System.out.println("\n el numero de asiento no es valido");
                    }
                } else {
                    System.out.println("\n el numero de fila no es valido");
                }
            }
            if (asientos[fila][asiento].equals("L")) {
                asientos[fila][asiento] = "X";
                System.out.println("el asiento fue reservado correctamente");
            } else {
                System.out.println("el asiento esta ocupado por favor elija otro");
            }
            System.out.println("¿Desea finalizar la resrva? S: si. N:no");
            respuesta = teclado.next();
            if (respuesta.equalsIgnoreCase("S")) {
                bandera = true;
            }
        }
    }

    static void dibujar(String asientos[][]) {
        for (int f = 0; f < 10; f++) {
            System.out.print(f + "-");
            for (int c = 0; c < 10; c++) {
                System.out.print(c + "");
                System.out.print("[" + asientos[f][c] + "] ");
            }
            System.out.println("");
        }
    }
}