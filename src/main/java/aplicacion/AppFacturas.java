package aplicacion;

import clases.*;
import excepciones.NoExisteClienteException;
import excepciones.NoExisteFacturaException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AppFacturas {

    public static void ejecutarMenu(Gestor gestor) {
        byte opcion;
        do {
            System.out.println(MenuFacturas.getMenu());
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige una opcion: ");
            opcion = scan.nextByte();
            MenuFacturas opcionMenuFacturas = MenuFacturas.getOpcion(opcion);

            switch (opcionMenuFacturas) {
                case EMITIR_FACTURA:
                    System.out.println(MenuFacturas.EMITIR_FACTURA.getDescripcion());
                    System.out.println("Introduzca un codigo identificativo para la factura: ");
                    String codigo = scan.next();
                    while(gestor.existeCodigoFactura(codigo)){
                        System.out.println("Codigo ya utilizado, introduzca otro codigo valido: ");
                        scan.next();
                    }
                    System.out.println("Introduzca el NIF del cliente: ");
                    String nif = scan.next();
                    Cliente clienteFactura;
                    try{
                        clienteFactura = gestor.getCliente(nif);
                    }catch (NoExisteClienteException e){
                        System.out.println("No existe un cliente con ese NIF.");
                        break;
                    }
                    Tarifa tarifa=clienteFactura.getTarifa();
                    System.out.println("Introduzca fecha de inicio de facturacion:");
                    LocalDateTime inicioFacturacion = gestor.pedirFecha();
                    System.out.println("Introduzca fecha de fin de facturacion:");
                    LocalDateTime finFacturacion=gestor.pedirFecha();
                    Factura nuevaFactura = new Factura(codigo,tarifa,inicioFacturacion,finFacturacion);
                    Factura facturaEmitida = gestor.emitirFactura(nuevaFactura,clienteFactura,LocalDateTime.now());
                    System.out.println("Factura emitida: ");
                    System.out.println(facturaEmitida);
                    break;
                case COLSULTAR_FACTURA:
                    System.out.println(MenuFacturas.COLSULTAR_FACTURA.getDescripcion());
                    System.out.println("Introduzca el codigo de la factura que desea consultar: ");
                    codigo = scan.next();
                    try{
                        Factura facturaConsultada=gestor.getFactura(codigo);
                        System.out.println(facturaConsultada);

                    }catch (NoExisteFacturaException e){
                        System.out.println("No existe ninguna factura con este codigo.");
                    }
                    break;
                case FACTURAS_INTERVALO:
                    System.out.println(MenuFacturas.FACTURAS_INTERVALO.getDescripcion());
                    System.out.println("Introduzca el NIF del cliente: ");
                    nif = scan.next();
                    System.out.println("Introduzca fecha de inicio del periodo:");
                    LocalDateTime fechaInicio = gestor.pedirFecha();
                    System.out.println("Introduzca fecha de fin del periodo:");
                    LocalDateTime fechaFin=gestor.pedirFecha();
                    try{
                        List<Factura> listaFacturasIntervalo= gestor.estaEnElIntervalo(gestor.getCliente(nif).getListaFacturas(),fechaInicio,fechaFin);
                        System.out.println(gestor.mostrarColleccion(listaFacturasIntervalo));
                    }catch (NoExisteClienteException e){
                        System.out.println("No existe ningun cliente con ese NIF");
                    }
                    break;
                case FACTURAS_CLIENTE:
                    System.out.println(MenuFacturas.FACTURAS_CLIENTE.getDescripcion()+"\nIntroduzca el NIF de un clinete: ");
                    nif=scan.next();
                    try{
                        List<Factura> listaFacturas=gestor.getFacturasCliente(nif);
                        System.out.println(gestor.mostrarColleccion(listaFacturas));
                    }catch (NoExisteClienteException e){
                        System.out.println("No existe un cliente con ese NIF");
                    }
                    break;
                case PRINCIPAL:
                    break;
            }
        } while (MenuFacturas.getOpcion(opcion) != MenuFacturas.PRINCIPAL);
    }
}
