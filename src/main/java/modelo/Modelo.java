package modelo;

import aplicacion.EntradaSalida;
import clases.*;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;
import excepciones.NoExisteFacturaException;
import vista.InterfaceVista;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Modelo implements InterfaceModelo{

    private Gestor gestor;
    private InterfaceVista vista;

    public Modelo(){
        this.gestor=new Gestor();
    }

    public void setVista(InterfaceVista vista){
        this.vista=vista;
    }

    @Override
    public void altaCliente(Cliente cliente){
        try {
            gestor.altaCliente(cliente);
        }catch (ClienteExistenteException e){}
    }
    @Override
    public void bajaCliente(String nif)  {
    try {
        gestor.bajaCliente(nif);
    }catch(NoExisteClienteException e){}
    }

    @Override
    public void añadirTarifaDia(String nif, float precio, int dia) {
        try {
            gestor.añadirTarifaDia(nif, precio, DayOfWeek.of(dia));
        } catch (NoExisteClienteException e){}


    }

    @Override
    public void añadirTarifaHora(String nif, float precio, int ini, int fin) {
        try {
        gestor.añadirTarifaHora(nif, precio, LocalTime.of(ini,0),LocalTime.of(fin,0));
        } catch (NoExisteClienteException e){}
    }

    @Override
    public String getListaClientes() {
        return gestor.mostrarColleccion(gestor.getListaClientes());

    }

    @Override
    public String getDatosCliente(String nif){
        try{
        return gestor.getCliente(nif).toString();
        }catch (NoExisteClienteException e){}
        return "No existe el cliente";
    }

    @Override
    public String ClientesEntreFechas(LocalDateTime fechaInicio,LocalDateTime fechaFinal){
        if(gestor.getListaClientes().isEmpty())return "No hay clientes";
        return gestor.mostrarColleccion(gestor.estaEnElIntervalo(gestor.getListaClientes(),fechaInicio,fechaFinal));
    }

    @Override
    public void generarClientesAutomaticos() {
        gestor.generarClientesAleatorios();
    }

    @Override
    public Cliente getObjetoCliente(String nif) {
        try {
            return gestor.getCliente(nif);
        }catch (NoExisteClienteException e){}
        return null;
    }

    @Override
    public void emitirFactura(Factura factura, String nif) {
        try {
            gestor.emitirFactura(factura, gestor.getCliente(nif), LocalDateTime.now());
        }catch (NoExisteClienteException e){}

    }

    @Override
    public String getFactura(String codFac) {
        try {
            return gestor.getFactura(codFac).toString();
        }catch(NoExisteFacturaException e){}
        return "No existe la factura";
    }

    @Override
    public String getFacturasCliente(String nif) {
        try{
            return gestor.mostrarColleccion(gestor.getFacturasCliente(nif));
        }catch (NoExisteClienteException e){}
        return "No existe el cliente";
    }

    @Override
    public String getFacturasIntervalo(LocalDateTime fechaIni, LocalDateTime fechaFin, String nif) {
        try {
            return gestor.mostrarColleccion(gestor.estaEnElIntervalo(gestor.getFacturasCliente(nif), fechaIni, fechaFin));
        }catch (NoExisteClienteException e){}
        return "No existe el cliente";
    }

    @Override
    public void anyadirLlamada(String nif, Llamada llamada) {
            gestor.altaLlamada(nif,llamada);
    }

    @Override
    public String getLlamadasCliente(String nif) {
        return gestor.mostrarColleccion(gestor.llamadasCliente(nif));
    }

    @Override
    public String llamadasIntervalo(String nif, LocalDateTime fechaIni, LocalDateTime fechaFin) {
        return gestor.mostrarColleccion(gestor.estaEnElIntervalo(gestor.llamadasCliente(nif),fechaIni,fechaFin));
    }

    @Override
    public void cargarFich(File fich) {
        EntradaSalida a = new EntradaSalida();
        gestor= a.cargarDatosFich(fich);
    }

    @Override
    public void guardarFich(File fich) {
        EntradaSalida a = new EntradaSalida();
        a.guardarDatosFich(gestor,fich);
    }
}
