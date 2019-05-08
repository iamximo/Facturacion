package modelo;

import clases.Gestor;
import clases.Particular;
import clases.TarifaDia;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;
import vista.InterfaceVista;
import clases.Cliente;

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
        return "";
    }

    @Override
    public String ClientesEntreFechas(LocalDateTime fechaInicio,LocalDateTime fechaFinal){
        return gestor.mostrarColleccion(gestor.estaEnElIntervalo(gestor.getListaClientes(),fechaInicio,fechaFinal));
    }

    @Override
    public void generarClientesAutomaticos() {
        gestor.generarClientesAleatorios();
    }
}
