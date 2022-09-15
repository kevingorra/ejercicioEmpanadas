package org.example;

import clases.Cliente;
import clases.Empanada;
import  java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empanada empanada = new Empanada("Empanada de Papa y Carne ","papa y carne",1200,5000);
        Cliente cliente = new Cliente();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


        int opcion = 100;

        Scanner lea =new Scanner(System.in);
        System.out.println("* MENU * ");
        System.out.println("1. Agregar  de Empanadas");
        System.out.println("2. Ver la Empanada");
        System.out.println("3. Editar Precio Empanada");
        System.out.println("5. Salir ");

        while(opcion!=5){
            System.out.println("Digite una opcion: ");
            opcion = lea.nextInt();
            if (opcion==1){
                System.out.println("Ingrese su saldo disponible : ");
                cliente.setSaldoDisponible(lea.nextInt());
                if (cliente.getSaldoDisponible()>=5000){
                    System.out.println("El ingrediente de la empanada es : "+empanada.getIngrediente());
                    System.out.println("El precio de la empanada es : "+empanada.getPrecioVenta());
                    System.out.println("Digita la cantidad de empanadas deseadas : ");
                    empanada.setCantidad(lea.nextInt());
                    if (empanada.calcularVenta()> cliente.getSaldoDisponible()){
                        System.out.println("No tienes Plata suficiente ");
                        System.out.println("Ingrese una cantidad menor");
                        empanada.setCantidad(lea.nextInt());

                    }else {
                        cliente.setSaldoDisponible(cliente.getSaldoDisponible()-empanada.calcularVenta());
                        System.out.println("Gracias por su compra : ");
                        System.out.println("Su nuevo saldo es : "+ cliente.getSaldoDisponible());
                    }

                }else{
                    System.out.println("no tienes Palata ");
                    break;
                }

            } else if (opcion==2) {

                System.out.println("*** Empanadas el Machetico ***");
                System.out.println("Regimen Comun ");
                System.out.println(dtf.format(LocalDateTime.now()));
                System.out.println("Producto : " +empanada.getNombre());
                System.out.println("Cantidad de empanadas compradas :" + empanada.getCantidad());
                System.out.println("El valor total es :" +empanada.calcularVenta());
                System.out.println("*** GRACIAS POR SU COMPRA ***");

            } else if (opcion==3) {

            } else if (opcion==5) {

            } else {

            }
        }
    }
}