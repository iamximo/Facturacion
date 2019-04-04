package clases;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {

    private float precio;

    public Tarifa(float precio){
        this.precio=precio;
    }

    public float getPrecio(Llamada llamada) {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract String toString();

}
