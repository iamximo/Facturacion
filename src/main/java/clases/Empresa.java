package clases;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Empresa extends  Cliente implements  Serializable{

    public Empresa(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        super(nombre, nif, direccion, email, fecha, precio);

    }


    public String toString(){
        return super.toString();
    }


}