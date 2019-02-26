package clases;

import java.time.LocalDateTime;

public class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        super(nombre, nif, direccion, email, fecha, precio);
        this.apellidos=apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }


}
