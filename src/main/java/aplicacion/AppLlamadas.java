package aplicacion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import clases.*;

public class AppLlamadas {

    public static void ejecutarMenu(Gestor gestor) {

        byte opcion;
        do {
            System.out.println(MenuLlamadas.getMenu());
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige una opcion: ");
            opcion = scan.nextByte();
            MenuLlamadas opcionMenuLlamadas = MenuLlamadas.getOpcion(opcion);

            switch (opcionMenuLlamadas) {
                case ALTA_LLAMADA:
                    System.out.println("Dar de alta una nueva llamada: ");
                    System.out.println("Introduzca el NIF de un cliente: ");
                    String nif=scan.next();
                    System.out.println("Introduzca el numero destino de la llamada: ");
                    String numDestino=scan.next();
                    System.out.println("Introduzca la fecha y hora que se realizó la llamada: \n Año: ");
                    int year=scan.nextInt();
                    System.out.println("Mes: ");
                    int month=scan.nextInt();
                    System.out.println("Dia: ");
                    int day=scan.nextInt();
                    System.out.println("Hora: ");
                    int hour=scan.nextInt();
                    System.out.println("Minuto: ");
                    int min=scan.nextInt();
                    LocalDateTime fechaHora=LocalDateTime.of(year,month,day,hour,min);
                    System.out.println("Introduzca la duracion de la llamada: ");
                    int duracion=scan.nextInt();
                    Llamada nuevaLlamada=new Llamada(numDestino,fechaHora,duracion);
                    gestor.altaLlamada(nif,nuevaLlamada);
                    break;
                case LLAMADAS_CLIENTE:
                    System.out.println("Consultar las llamadas de un cliente: \n Introduzca el NIF de un cliente:");
                    nif=scan.next();
                    List<Llamada> listaLlamadas=gestor.llamadasCliente(nif);
                    System.out.println("Llamadas realizadas por "+nif+" : ");
                    for(Llamada llamada:listaLlamadas){
                        System.out.println(llamada);
                    }
                    break;
                case PRINCIPAL:
                    break;
            }

        } while (MenuLlamadas.getOpcion(opcion) != MenuLlamadas.PRINCIPAL);
    }
}
