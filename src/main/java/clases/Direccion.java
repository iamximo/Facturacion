package clases;

import javax.print.DocFlavor;

public class Direccion {
    private int codigoPostal;
    private String provincia;
    private String poblacion;

    public Direccion(int codigoPostal, String provincia, String poblacion){
        this.codigoPostal=codigoPostal;
        this.provincia=provincia;
        this.poblacion=poblacion;
    }

    public int getCodigoPostal(){
        return codigoPostal;
    }

    public String getProvincia(){
        return provincia;
    }

    public String getPoblacion(){
        return poblacion;
    }

    public String toString(){
        return "\n\tPROVINCIA: "+getProvincia()+"\n\tPOBLACION: "+getPoblacion()+"\n\tCODIGO POSTAL: "+getCodigoPostal();
    }

}
