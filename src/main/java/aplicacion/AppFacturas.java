package aplicacion;

import clases.*;

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
                    System.out.println("Emitir una nueva factura");
                    System.out.println("Introduzca un codigo identificativo para la factura: ");
                    String codigo = scan.next();
                    while(gestor.existeCodigoFactura(codigo)){
                        System.out.println("Codigo ya utilizado, introduzca otro codigo valido: ");
                        scan.next();
                    }
                    System.out.println("Introduzca el NIF del cliente: ");
                    String nif = scan.next();
                    Cliente clienteFactura = gestor.getCliente(nif);
                    Tarifa tarifa=clienteFactura.getTarifa();
                    System.out.println("Introduzca fecha de inicio de facturacion:");
                    System.out.println("Año:");
                    int year=scan.nextInt();
                    System.out.println("Mes: ");
                    int month=scan.nextInt();
                    System.out.println("Dia: ");
                    int day=scan.nextInt();
                    LocalDateTime inicioFacturacion = LocalDateTime.of(year,month,day,0,0);
                    System.out.println("Introduzca fecha de fin de facturacion:");
                    System.out.println("Año:");
                    year=scan.nextInt();
                    System.out.println("Mes: ");
                    month=scan.nextInt();
                    System.out.println("Dia: ");
                    day=scan.nextInt();
                    LocalDateTime finFacturacion=LocalDateTime.of(year,month,day,23,59);
                    Factura nuevaFactura = new Factura(codigo,tarifa,inicioFacturacion,finFacturacion);
                    Factura facturaEmitida = gestor.emitirFactura(nuevaFactura,clienteFactura,LocalDateTime.now());
                    System.out.println("Factura emitida: ");
                    System.out.println(facturaEmitida);
                    break;
                case COLSULTAR_FACTURA:
                    System.out.println("Consultar datos de una factura: ");
                    System.out.println("Introduzca el codigo de la factura que desea consultar: ");
                    codigo = scan.next();
                    if(!gestor.existeCodigoFactura(codigo)){
                        System.out.println("El codigo introducido no es valido. ");
                        break;
                    }
                    Factura facturaConsultada=gestor.getFactura(codigo);
                    System.out.println(facturaConsultada);
                    break;
                case FACTURAS_CLIENTE:
                    System.out.println("Consultar las facturas de un cliente: \nIntroduzca el NIF de un clinete: ");
                    nif=scan.next();
                    List<Factura> listaFacturas=gestor.getFacturasCliente(nif);
                    for(Factura factura:listaFacturas) System.out.println(factura);
                    break;
                case PRINCIPAL:
                    break;
            }
        } while (MenuFacturas.getOpcion(opcion) != MenuFacturas.PRINCIPAL);
    }
}
