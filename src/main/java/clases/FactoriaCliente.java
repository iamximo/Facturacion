package clases;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FactoriaCliente implements FabricaClientes, Serializable {

    public FactoriaCliente(){
        super();
    }

    @Override
    public Empresa getEmpresaNuevo(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        return new Empresa(nombre,nif,direccion,email,fecha,precio);

    }

    public Particular getParticularNuevo(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        return new Particular(nombre,apellidos,nif,direccion,email,fecha,precio);
    }




}
