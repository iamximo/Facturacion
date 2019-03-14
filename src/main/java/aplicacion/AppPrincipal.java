package aplicacion;
import clases.Gestor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class AppPrincipal { //Falta poner fuera del main, poner fuera de los case y arreglar EntradaSalida


    Gestor gestor = new Gestor();

    public void runMenu(){

        System.out.println('\n');
        System.out.println("Bienvenido. Introduzca el numero de la opcion para elegir.");
        byte opcion;
        do {
            System.out.println(MenuPrincipal.getMenu());
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige una opcion: ");
            opcion = scan.nextByte();
            MenuPrincipal opcionMenuPrincipal = MenuPrincipal.getOpcion(opcion);

            switch (opcionMenuPrincipal) {
                case CLIENTES:
                    AppCliente.ejecutarMenu(gestor);
                    break;
                case FACTURAS:
                    AppFacturas.ejecutarMenu(gestor);
                    break;
                case LLAMADAS:
                    AppLlamadas.ejecutarMenu(gestor);
                    break;
                case CARGAR:
                    try{
                        EntradaSalida a=new EntradaSalida();
                        gestor=a.cargarDatos();
                    }catch (FileNotFoundException e){}
                    break;
                case GUARDAR:
                    try{
                        new EntradaSalida().guardarDatos(gestor);
                    }catch (FileNotFoundException e){}
                    break;
                case SALIR:
                    System.out.println("Hasta pronto :) ");
                    break;
            }

        }while(MenuPrincipal.getOpcion(opcion)!=MenuPrincipal.SALIR);

    }


}