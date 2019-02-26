package clases;

import java.time.LocalDateTime;

public class Factura implements Fecha{

    private String codigo;
    private Tarifa tarifa;
    private LocalDateTime fechaEmision;
    private LocalDateTime inicioFacturacion;
    private LocalDateTime finFacturacion;
    private float importe;

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


}
