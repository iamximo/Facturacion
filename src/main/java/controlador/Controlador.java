package controlador;

import vista.InterfaceVista;
import modelo.InterfaceModelo;

public class Controlador implements InterfaceControlador {
    private InterfaceVista vista;
    private InterfaceModelo modelo;

    public Controlador(){}

    public void setVista(InterfaceVista vista){
        this.vista=vista;
    }
    public void setModelo(InterfaceModelo modelo){
        this.modelo=modelo;
    }

    public void nuevoCliente(){
        //Pasa al modelo
        System.out.println("Cliente creado");
    }

}
