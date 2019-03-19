package aplicacion;
import clases.*;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;

import java.awt.geom.NoninvertibleTransformException;
import java.time.LocalDateTime;
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
                case ALTA_NUEVO_CLIENTE:
                    System.out.println(MenuCliente.ALTA_NUEVO_CLIENTE.getDescripcion());
                    System.out.println("Introduzca el nombre: ");
                    String nombre = scan.next();
                    System.out.println("Introduzca NIF: ");
                    String nif = scan.next();
                    System.out.println("Introduzca el codigo postal: ");
                    int cp;
                    try {
                        cp = scan.nextInt();
                    }catch (InputMismatchException e){
                        cp=0;
                        System.out.println("Codigo postal tiene que ser numerico");
                        break;
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
                    Cliente nuevo = new Cliente(nombre, nif,direccion,email, LocalDateTime.now(), precio);
                    try{
                        gestor.altaCliente(nuevo);
                        System.out.println("\n Cliente introducido correctamente.");
                    }
                    catch(ClienteExistenteException e){
                        System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
                    }


                    break;
                case ALTA_NUEVO_PARTICULAR:
                    System.out.println(MenuCliente.ALTA_NUEVO_CLIENTE.getDescripcion());
                    System.out.println("Introduzca el nombre: ");
                    nombre = scan.next();
                    System.out.println("Introduzca apellidos:");
                    String apellidos = scan.next();
                    System.out.println("Introduzca NIF: ");
                    nif = scan.next();
                    System.out.println("Introduzca el codigo postal: ");
                    try {
                        cp = scan.nextInt();
                    }catch (InputMismatchException e){
                        cp=0;
                        System.out.println("Codigo postal tiene que ser numerico");
                        break;
                    }
                    System.out.println("Introduzca provincia: ");
                    provincia = scan.next();
                    System.out.println("Introduzca poblacion: ");
                    poblacion = scan.next();
                    direccion= new Direccion(cp,provincia,poblacion);
                    System.out.println("Introduzca email: ");
                    email = scan.next();
                    System.out.println("Introduzca precio de la tarifa: ");
                    precio = scan.nextFloat();
                    nuevo = new Particular(nombre, apellidos, nif,direccion,email, LocalDateTime.now(), precio);
                    try{
                        gestor.altaCliente(nuevo);
                        System.out.println("\n Cliente introducido correctamente.");
                    }
                    catch(ClienteExistenteException e){
                        System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
                    }
                case BORRAR_CLIENTE:
                    System.out.println(MenuCliente.BORRAR_CLIENTE.getDescripcion());
                    System.out.println("Introduzca el NIF del cliente que desea eliminar: ");
                    nif=scan.next();
                    try{
                        gestor.bajaCliente(nif);
                        System.out.println("Cliente borrado correctamente");
                    }catch (NoExisteClienteException e) {
                        System.out.println("Cliente no borrado, no existe un cliente con dicho NIF.");
                    }
                    break;
                case CAMBIO_TARIFA:
                    System.out.println(MenuCliente.CAMBIO_TARIFA.getDescripcion());
                    System.out.println("Introduzca el NIF delcliente al que desea cambiar la tarifa: ");
                    nif=scan.next();
                    System.out.println("Introduzca el nuevo precio de la tarifa: ");
                    precio=scan.nextFloat();
                    try{
                        gestor.cambioTarifa(nif,precio);
                        System.out.println("Cambio de tarifa efectuado correctamente.");
                    }catch (NoExisteClienteException e){
                        System.out.println("No se ha cambiado la tarifa, el cliente introducido no existe.");
                    }
                    break;
                case DATOS_CLIENTE:
                    System.out.println(MenuCliente.DATOS_CLIENTE.getDescripcion());
                    System.out.println("Introduzca el NIF del cliente: ");
                    nif=scan.next();
                    try{
                        Cliente clienteConsultado = gestor.getCliente(nif);
                        System.out.println(clienteConsultado);
                    }catch (NoExisteClienteException e){
                        System.out.println("No existe un cliente con dicho NIF");
                    }
                    break;
                case LISTADO_CLIENTES:
                    System.out.println(MenuCliente.LISTADO_CLIENTES.getDescripcion());
                    Collection<Cliente> listaClientes = gestor.getListaClientes();
                    System.out.println(gestor.mostrarColleccion(listaClientes));
                    break;
                case LISTADO_CLIENTES_FECHA:
                    System.out.println(MenuCliente.LISTADO_CLIENTES_FECHA.getDescripcion());
                    System.out.println("Introduzca fecha de inicio del periodo:");
                    LocalDateTime fechaInicio = gestor.pedirFecha();
                    System.out.println("Introduzca fecha de fin del periodo:");
                    LocalDateTime fechaFin=gestor.pedirFecha();
                    List<Cliente> listaClientesIntervalo= gestor.estaEnElIntervalo(gestor.getListaClientes(),fechaInicio,fechaFin);
                    System.out.println(gestor.mostrarColleccion(listaClientesIntervalo));
                    break;
                case AUTOMATICO:
                    System.out.println(MenuCliente.AUTOMATICO.getDescripcion());
                    gestor.generarClientesAleatorios();
                    System.out.println("Clientes generados correctamente.");
                    break;
                case PRINCIPAL:
                    System.out.println(MenuCliente.PRINCIPAL.getDescripcion());
                    break;

            }

        }while(MenuCliente.getOpcion(opcion)!=MenuCliente.PRINCIPAL);

    }


}
