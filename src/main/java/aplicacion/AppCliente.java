package aplicacion;
import clases.*;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class AppCliente {


    public static void ejecutarMenu(Gestor gestor){

        byte opcion;
        do {
            System.out.println("\n Menu de gestion de clientes: \n");
            System.out.println(MenuCliente.getMenu());
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige una opcion: ");
            opcion = scan.nextByte();
            MenuCliente opcionMenuCliente = MenuCliente.getOpcion(opcion);

            switch (opcionMenuCliente) {
                case ALTA_NUEVO_EMPRESA:
                    altaEmpresa(gestor);
                    break;
                case ALTA_NUEVO_PARTICULAR:
                    altaParticular(gestor);
                    break;
                case BORRAR_CLIENTE:
                    borrarCliente(gestor);
                    break;
                case CAMBIO_TARIFA:
                    cambioTarifa(gestor);
                    break;
                case DATOS_CLIENTE:
                    datosCliente(gestor);
                    break;
                case LISTADO_CLIENTES:
                    listadoClientes(gestor);
                    break;
                case LISTADO_CLIENTES_FECHA:
                    listadoClientesFecha(gestor);
                    break;
                case AUTOMATICO:
                    automatico(gestor);
                    break;
                case PRINCIPAL:
                    System.out.println(MenuCliente.PRINCIPAL.getDescripcion());
                    break;

            }

        }while(MenuCliente.getOpcion(opcion)!=MenuCliente.PRINCIPAL);

    }



    private static void altaEmpresa(Gestor gestor){
        FactoriaCliente fabrica= new FactoriaCliente();
        Scanner scan = new Scanner(System.in);
        System.out.println(MenuCliente.ALTA_NUEVO_EMPRESA.getDescripcion());
        System.out.println("Introduzca el nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Introduzca NIF: ");
        String nif = scan.next();
        System.out.println("Introduzca el codigo postal: ");
        int cp;
        try {
            cp = scan.nextInt();
        }catch (InputMismatchException e){
            cp=0;
            System.out.println("Codigo postal tiene que ser numerico");
            return;
        }
        System.out.println("Introduzca provincia: ");
        String provincia = scan.next();
        System.out.println("Introduzca poblacion: ");
        String poblacion = scan.next();
        Direccion direccion= new Direccion(cp,provincia,poblacion);
        System.out.println("Introduzca email: ");
        String email = scan.next();
        System.out.println("Introduzca precio de la tarifa: ");
        float precio = scan.nextFloat();
        Cliente nuevo = fabrica.getEmpresaNuevo(nombre, nif,direccion,email, LocalDateTime.now(), precio);
        try{
            gestor.altaCliente(nuevo);
            System.out.println("\n Cliente introducido correctamente.");
        }
        catch(ClienteExistenteException e){
            System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
        }


    }

    private static void altaParticular(Gestor gestor){
        FactoriaCliente fabrica=new FactoriaCliente();
        Scanner scan = new Scanner(System.in);
        System.out.println(MenuCliente.ALTA_NUEVO_EMPRESA.getDescripcion());
        System.out.println("Introduzca el nombre: ");
        String nombre = scan.next();
        System.out.println("Introduzca apellidos:");
        String apellidos = scan.next();
        System.out.println("Introduzca NIF: ");
        String nif = scan.next();
        System.out.println("Introduzca el codigo postal: ");
        int cp;
        try {
            cp = scan.nextInt();
        }catch (InputMismatchException e){
            cp=0;
            System.out.println("Codigo postal tiene que ser numerico");
            return;
        }
        System.out.println("Introduzca provincia: ");
        String provincia = scan.next();
        System.out.println("Introduzca poblacion: ");
        String poblacion = scan.next();
        Direccion direccion= new Direccion(cp,provincia,poblacion);
        System.out.println("Introduzca email: ");
        String email = scan.next();
        System.out.println("Introduzca precio de la tarifa: ");
        float precio = scan.nextFloat();
        Cliente nuevo=fabrica.getParticularNuevo(nombre, apellidos, nif,direccion,email, LocalDateTime.now(), precio);
        try{
            gestor.altaCliente(nuevo);
            System.out.println("\n Cliente introducido correctamente.");
        }
        catch(ClienteExistenteException e){
            System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
        }
    }

    private static void borrarCliente(Gestor gestor){
        System.out.println(MenuCliente.BORRAR_CLIENTE.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF del cliente que desea eliminar: ");
        String nif=scan.next();
        try{
            gestor.bajaCliente(nif);
            System.out.println("Cliente borrado correctamente");
        }catch (NoExisteClienteException e) {
            System.out.println("Cliente no borrado, no existe un cliente con dicho NIF.");
        }
    }

    private static void cambioTarifa(Gestor gestor){


        System.out.println(MenuCliente.CAMBIO_TARIFA.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF del cliente al que desea cambiar la tarifa: ");
        String nif=scan.next();


        boolean fin=false;
        while(!fin){
            System.out.println("Indica que tarifa quieres añadir: ");
            System.out.println("1.  Tarifa de hora");
            System.out.println("2.  Tarifa de dia");
            System.out.println("3.  Salir");
            int tar=scan.nextInt();
            if(tar==3) break;
            if(tar==1){
                System.out.println("Introduzca el nuevo precio de la tarifa de horas : ");
                float prec=scan.nextFloat();
                System.out.println("Introduzca la hora de inicio: ");
                LocalTime ini=LocalTime.of(scan.nextInt(),0);
                System.out.println("Introduzca la hora de fin: ");
                LocalTime fi=LocalTime.of(scan.nextInt(),0);
                try{
                    gestor.añadirTarifaHora(nif,prec,ini,fi);
                }catch(NoExisteClienteException e){}

            }
            if(tar==2){
                System.out.println("Introduzca el nuevo precio de la tarifa de dia : ");
                float prec=scan.nextFloat();
                System.out.println("Introduzca el dia de inicio: ");
                System.out.println("1.LUNES\t2.MARTES\t3.MIERCOLES\t4.JUEVES\t5.VIERNES\t6.SABADO\t7.DOMINGO");
                int dia=scan.nextInt();
                DayOfWeek diae=DayOfWeek.SUNDAY;
                switch (dia) {
                    case 1:
                        diae=DayOfWeek.MONDAY;
                        break;
                    case 2:
                        diae=DayOfWeek.TUESDAY;
                        break;
                    case 3:
                        diae=DayOfWeek.WEDNESDAY;
                        break;
                    case 4:
                        diae=DayOfWeek.THURSDAY;
                        break;
                    case 5:
                        diae=DayOfWeek.FRIDAY;
                        break;
                    case 6:
                        diae=DayOfWeek.SATURDAY;
                        break;
                    case 7:
                        diae=DayOfWeek.SUNDAY;
                        break;

                }
                try {
                    gestor.añadirTarifaDia(nif, prec, diae);
                }catch(NoExisteClienteException e){}

            }
        }







    }

    private static void datosCliente(Gestor gestor){
        System.out.println(MenuCliente.DATOS_CLIENTE.getDescripcion());
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el NIF del cliente: ");
        String nif=scan.next();
        try{
            Cliente clienteConsultado = gestor.getCliente(nif);
            System.out.println(clienteConsultado);
        }catch (NoExisteClienteException e){
            System.out.println("No existe un cliente con dicho NIF");
        }
    }

    private static void listadoClientes(Gestor gestor){
        System.out.println(MenuCliente.LISTADO_CLIENTES.getDescripcion());
        Collection<Cliente> listaClientes = gestor.getListaClientes();
        System.out.println(gestor.mostrarColleccion(listaClientes));
    }

    private static void listadoClientesFecha(Gestor gestor){
        System.out.println(MenuCliente.LISTADO_CLIENTES_FECHA.getDescripcion());
        System.out.println("Introduzca fecha de inicio del periodo:");
        LocalDateTime fechaInicio = gestor.pedirFecha();
        System.out.println("Introduzca fecha de fin del periodo:");
        LocalDateTime fechaFin=gestor.pedirFecha();
        List<Cliente> listaClientesIntervalo= gestor.estaEnElIntervalo(gestor.getListaClientes(),fechaInicio,fechaFin);
        System.out.println(gestor.mostrarColleccion(listaClientesIntervalo));
    }

    private static void automatico(Gestor gestor){
        System.out.println(MenuCliente.AUTOMATICO.getDescripcion());
        gestor.generarClientesAleatorios();
        System.out.println("Clientes generados correctamente.");
    }
}
