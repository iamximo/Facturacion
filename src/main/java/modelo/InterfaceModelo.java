package modelo;

import clases.Cliente;
import clases.Factura;
import clases.Llamada;
import clases.TarifaDia;

import java.time.LocalDateTime;
import java.util.List;

public interface InterfaceModelo {

    void altaCliente(Cliente cli);
    void bajaCliente(String nif);
    void añadirTarifaDia(String nif, float precio, int dia);
    void añadirTarifaHora(String nif, float precio, int ini, int fin);
    String getListaClientes();
    String getDatosCliente(String nif);
    String ClientesEntreFechas(LocalDateTime fechaInicio,LocalDateTime fechaFinal);
    void generarClientesAutomaticos();
}