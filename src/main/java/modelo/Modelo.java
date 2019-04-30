package modelo;

import clases.Gestor;
import vista.InterfaceVista;

public class Modelo implements InterfaceModelo{

    private Gestor gestor;
    private InterfaceVista vista;

    public Modelo(){
        this.gestor=new Gestor();
    }

    public void setVista(InterfaceVista vista){
        this.vista=vista;
    }





}
