package clases;

import java.io.Serializable;

public class Tarifa implements Serializable {

    private float precio;

    public Tarifa(float precio){
        this.precio=precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String toString(){
        return String.valueOf(this.precio);
    }

}
