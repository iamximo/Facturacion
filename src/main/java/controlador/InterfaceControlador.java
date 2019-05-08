package controlador;

import clases.Cliente;
import clases.Direccion;
import clases.Factura;
import clases.Llamada;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface InterfaceControlador {




    void altaParticular(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio);
    void altaEmpresa(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio);
    void bajaCliente(String nif);
    void añadirTarifaDia(String nif, float precio, int dia);
    void añadirTarifaHora(String nif, float precio, int ini, int fin);
    String  getCliente(String nif);
    String getListaClientes();
    String clientesIntervalo(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
    void generarClientesAleatorios();


    /*
    void emitirFactura();
    void getFactura();
    void consultarFacturasCliente();
    void cosultarFacturasClienteIntervalo();



    void altaLlamada();
    void consultarLlamadasCliente();
    void consultarLlamadasClienteIntervalo();
    */
}
