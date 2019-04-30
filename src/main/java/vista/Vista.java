package vista;

import modelo.InterfaceModelo;
import controlador.InterfaceControlador;

import javax.swing.*;


public class Vista implements InterfaceVista{
    private InterfaceControlador controlador;
    private InterfaceModelo modelo;

    public Vista(){
        crearInterfazVisual();
    }

    public void setControlador(InterfaceControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterfaceModelo modelo) {
        this.modelo = modelo;
    }

    private void crearInterfazVisual(){
        JFrame ventanaPrincipal = new JFrame("Facturation OMLoL");
        ventanaPrincipal.setSize(400,400);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
