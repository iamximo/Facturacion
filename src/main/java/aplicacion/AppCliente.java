package aplicacion;
import clases.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Scanner;

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
                    System.out.println("Dar de alta nuevo cliente:");
                    System.out.println("Introduzca el nombre: ");
                    String nombre = scan.next();
                    System.out.println("Introduzca NIF: ");
                    String nif = scan.next();
                    System.out.println("Introduzca el codigo postal: ");
                    int cp = scan.nextInt();
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
                    boolean introducido = gestor.altaCliente(nuevo);
                    if (introducido) System.out.println("\n Cliente introducido correctamente.");
                    else System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
                    break;
                case ALTA_NUEVO_PARTICULAR:
                    System.out.println("Dar de alta nuevo cliente particular:");
                    System.out.println("Introduzca el nombre: ");
                    nombre = scan.next();
                    System.out.println("Introduzca apellidos:");
                    String apellidos = scan.next();
                    System.out.println("Introduzca NIF: ");
                    nif = scan.next();
                    System.out.println("Introduzca el codigo postal: ");
                    cp = scan.nextInt();
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
                    introducido = gestor.altaCliente(nuevo);
                    if (introducido) System.out.println("\n Cliente introducido correctamente.");
                    else System.out.println("\nCliente no introducido, ya existe un cliente con este NIF.");
                    break;
                case BORRAR_CLIENTE:
                    System.out.println("Borrar un cliente:");
                    System.out.println("Introduzca el NIF del cliente que desea eliminar: ");
                    nif=scan.next();
                    boolean borrado = gestor.bajaCliente(nif);
                    if (borrado) System.out.println("Cliente borrado correctamente");
                    else System.out.println("Cliente no borrado, no existe un clinete con dicho NIF.");
                    break;
                case CAMBIO_TARIFA:
                    System.out.println("Cambiar l atarifa de un cliente:");
                    System.out.println("Introduzca el NIF delcliente al que desea cambiar la tarifa: ");
                    nif=scan.next();
                    System.out.println("Introduzca el nuevo precio de la tarifa: ");
                    precio=scan.nextFloat();
                    gestor.cambioTarifa(nif,precio);
                    break;
                case DATOS_CLIENTE:
                    System.out.println("Consultar los datos de un cliente: ");
                    System.out.println("Introduzca el NIF del cliente: ");
                    nif=scan.next();
                    Cliente clienteConsultado = gestor.getCliente(nif);
                    System.out.println(clienteConsultado);
                    break;
                case LISTADO_CLIENTES:
                    System.out.println("Consultar el listado de todos los clientes: ");
                    Collection<Cliente> listaClientes = gestor.getListaClientes();
                    int i=0;
                    for (Cliente client : listaClientes){
                        System.out.print(i + ".-");
                        System.out.println(client.getNif() + "---" + client.getNombre());
                        i++;
                    }
                    break;
                case AUTOMATICO:
                    System.out.println("Dar de alta clientes de forma automatica: ");
                    gestor.generarClientesAleatorios();
                    System.out.println("Clientes generados");
                    break;
                case PRINCIPAL:
                    System.out.println("Volver al menu principal.");
                    break;

            }

        }while(MenuCliente.getOpcion(opcion)!=MenuCliente.PRINCIPAL);

    }


}
