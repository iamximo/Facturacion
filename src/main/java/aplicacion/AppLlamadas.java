package aplicacion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import clases.*;
import excepciones.NoExisteClienteException;

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
                    altaLlamada(gestor);
                    break;
                case LLAMADAS_CLIENTE:
                    llamadasCliente(gestor);
                    break;
                case LLAMADAS_INTERVALO:
                    llamadasIntervalo(gestor);
                    break;
                case PRINCIPAL:
                    break;
            }

        } while (MenuLlamadas.getOpcion(opcion) != MenuLlamadas.PRINCIPAL);
    }

    private static void altaLlamada(Gestor gestor){
        System.out.println(MenuLlamadas.ALTA_LLAMADA.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF de un cliente: ");
        String nif=scan.next();
        System.out.println("Introduzca el numero destino de la llamada: ");
        String numDestino=scan.next();
        System.out.println("Introduzca la fecha y hora que se realizó la llamada: ");
        LocalDateTime fechaHora=gestor.pedirFecha();
        System.out.println("Introduzca la duracion de la llamada: ");
        int duracion=scan.nextInt();
        Llamada nuevaLlamada=new Llamada(numDestino,fechaHora,duracion);
        gestor.altaLlamada(nif,nuevaLlamada);

    }

    private static void llamadasCliente(Gestor gestor){
        System.out.println(MenuLlamadas.LLAMADAS_CLIENTE.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF de un cliente:");
        String nif=scan.next();
        List<Llamada> listaLlamadas=gestor.llamadasCliente(nif);
        System.out.println("Llamadas realizadas por " + nif + " : ");
        System.out.println(gestor.mostrarColleccion(listaLlamadas));
    }

    private static void llamadasIntervalo(Gestor gestor){
        System.out.println(MenuLlamadas.LLAMADAS_INTERVALO.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF del cliente: ");
        String nif = scan.next();
        System.out.println("Introduzca fecha de inicio del periodo:");
        LocalDateTime fechaInicio = gestor.pedirFecha();
        System.out.println("Introduzca fecha de fin del periodo:");
        LocalDateTime fechaFin=gestor.pedirFecha();
        try{
            List<Llamada> listaLlamadasIntervalo= gestor.estaEnElIntervalo(gestor.getCliente(nif).getListaLlamadas(),fechaInicio,fechaFin);
            System.out.println(gestor.mostrarColleccion(listaLlamadasIntervalo));
        }catch (NoExisteClienteException e){
            System.out.println("No existe ningun cliente con ese NIF.");
        }
    }
}
