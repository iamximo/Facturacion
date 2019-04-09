package clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Fecha, Serializable {

    private  String nombre;
    private String nif;
    private Direccion direccion;
    private String email;
    private LocalDateTime fecha;
    private Tarifa tarifa;
    private List<Llamada> listaLlamadas;
    private List<Factura> listaFacturas;

    FactoriaTarifa fabrica=new FactoriaTarifa();


    public Cliente(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        this.nombre=nombre;
        this.nif=nif;
        this.direccion=direccion;
        this.email=email;
        this.fecha=fecha;
        this.tarifa =fabrica.getTarifaBasica(precio);
        this.listaLlamadas = new ArrayList<Llamada>();
        this.listaFacturas = new ArrayList<Factura>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void cambiarTarifa(float nuevoPrecio){
        tarifa.setPrecio(nuevoPrecio);
    }

    public List<Llamada> getListaLlamadas(){
        return listaLlamadas;
    }
    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }
    public void addLlamada(Llamada llamada){
        this.listaLlamadas.add(llamada);
    }
    public void addFactura(Factura factura){ this.listaFacturas.add(factura);}

    public String toString(){
        return "\nNIF: "+this.getNif()+"\nNOMBRE: "+this.getNombre()+"\nDIRECCION: "+this.getDireccion().toString()+"\nEMAIL: "+this.getEmail()+"\nFECHA: "+this.getFecha()+"\nTARIFA: "+this.getTarifa().toString();
    }



}
