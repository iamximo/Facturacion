package controlador;

import clases.*;
import vista.InterfaceVista;
import modelo.InterfaceModelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Controlador implements InterfaceControlador {
    private InterfaceVista vista;
    private InterfaceModelo modelo;

    public Controlador(){}

    public void setVista(InterfaceVista vista){
        this.vista=vista;
    }
    public void setModelo(InterfaceModelo modelo){
        this.modelo=modelo;
    }


    @Override
    public void altaParticular(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio) {
        Cliente particular = new Particular(nombre,apellidos,nif,direccion,email,fecha,precio);
        modelo.altaCliente(particular);
    }

    @Override
    public void altaEmpresa(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio) {
        Cliente empresa = new Empresa(nombre,nif,direccion,email,fecha,precio);
        modelo.altaCliente(empresa);
    }

    @Override
    public void bajaCliente(String nif) {
        modelo.bajaCliente(nif);

    }

    @Override
    public void añadirTarifaDia(String nif, float precio, int dia) {

        modelo.añadirTarifaDia(nif,precio,dia);
    }

    @Override
    public void añadirTarifaHora(String nif, float precio, int ini, int fin) {

        modelo.añadirTarifaHora(nif,precio,ini,fin);

    }

    @Override
    public String getCliente(String nif) {
        return modelo.getDatosCliente(nif);

    }

    @Override
    public String getListaClientes() {
        return modelo.getListaClientes();

    }

    @Override
    public String clientesIntervalo(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        return  modelo.ClientesEntreFechas(fechaInicio,fechaFinal);

    }

    @Override
    public void generarClientesAleatorios() {
        modelo.generarClientesAutomaticos();
    }

    @Override
    public Cliente getObjetoCliente(String nif) {
        return modelo.getObjetoCliente(nif);

    }

    @Override
    public void emitirFactura(Factura factura, String nif) {
        modelo.emitirFactura(factura,nif);
    }

    @Override
    public String getFactura(String codfac) {
        return modelo.getFactura(codfac);
    }

    @Override
    public String getFacturasCliente(String nif) {
        return modelo.getFacturasCliente(nif);
    }

    @Override
    public String getFacturasIntervalo(LocalDateTime fechaIni, LocalDateTime fechaFin, String nif) {
        return modelo.getFacturasIntervalo(fechaIni,fechaFin,nif);
    }
}
