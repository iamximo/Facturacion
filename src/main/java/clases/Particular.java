package clases;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Particular extends Cliente implements Serializable {

    private String apellidos;

    public Particular(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        super(nombre, nif, direccion, email, fecha, precio);
        this.apellidos=apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String toString(){
        return super.toString()+"\nAPELLIDOS: "+getApellidos();
    }


}
