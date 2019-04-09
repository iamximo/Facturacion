package clases;

import java.time.LocalDateTime;

public class FactoriaCliente implements FabricaClientes{

    public FactoriaCliente(){
        super();
    }

    @Override
    public Cliente getEmpresaNuevo(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        return new Cliente(nombre,nif,direccion,email,fecha,precio);

    }

    public Particular getParticularNuevo(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio){
        return new Particular(nombre,apellidos,nif,direccion,email,fecha,precio);
    }




}
