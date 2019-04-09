package clases;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {

    protected float precio;

    public Tarifa(float precio){
        this.precio=precio;
    }

    public float getPrecioTarifa(Llamada llamada) {
        return precio*llamada.getDuracion();
    }

    public float getPrecio(){
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract String toString();

}
