package aplicacion;
import clases.Gestor;

import java.util.Scanner;

public class AppPrincipal {

    public static void main(String[] args){
        Gestor gestor = new Gestor();
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
                case SALIR:
                    System.out.println("Hasta pronto :) ");
                    break;
            }

        }while(MenuPrincipal.getOpcion(opcion)!=MenuPrincipal.SALIR);

    }
}
