package clases;

import java.time.LocalDateTime;

public interface FabricaClientes {

    Cliente getEmpresaNuevo(String nombre, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio);
    Particular getParticularNuevo(String nombre, String apellidos, String nif, Direccion direccion, String email, LocalDateTime fecha, float precio);

}
