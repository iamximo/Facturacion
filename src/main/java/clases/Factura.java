package clases;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Factura implements Fecha, Serializable {

    private String codigo;
    private Tarifa tarifa;
    private LocalDateTime fechaEmision=null;
    private LocalDateTime inicioFacturacion;
    private LocalDateTime finFacturacion;
    private float importe=0;

    public Factura(String codigo, Tarifa tarifa, LocalDateTime inicioFacturacion, LocalDateTime finFacturacion){
        this.codigo=codigo;
        this.tarifa=tarifa;
        this.inicioFacturacion=inicioFacturacion;
        this.finFacturacion=finFacturacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public LocalDateTime getFecha() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision){
        this.fechaEmision=fechaEmision;
    }

    public void setImporte(float importe){
        this.importe=importe;
    }

    public LocalDateTime getInicioFacturacion() {
        return inicioFacturacion;
    }

    public LocalDateTime getFinFacturacion() {
        return finFacturacion;
    }

    public float getImporte() {
        return importe;
    }

    public String toString(){
        return "TARIFA: "+tarifa.toString()+"\n INICIO FACT: "+this.inicioFacturacion+"\n FIN FACT: "+this.finFacturacion+"\nFECHA EMISION: "+this.fechaEmision + "\nIMPORTE: "+this.importe;
    }




}
