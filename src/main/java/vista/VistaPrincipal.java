package vista;

import modelo.InterfaceModelo;
import controlador.InterfaceControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaClientes.*;


public class VistaPrincipal implements InterfaceVista{
    private InterfaceControlador controlador;
    private InterfaceModelo modelo;

    public VistaPrincipal(){ crearInterfazVisual();
    }

    public void setControlador(InterfaceControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterfaceModelo modelo) {
        this.modelo = modelo;
    }

    private void crearInterfazVisual(){
        JFrame ventanaPrincipal = new JFrame("Facturation OMLoL");

        Container contenedor = ventanaPrincipal.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));


        JButton botonCli = new JButton("Menu clientes");
        JButton botonFac = new JButton("Menu facturas");
        JButton botonLLam = new JButton("Menu llamadas");
        contenedor.add(botonCli, BorderLayout.WEST);
        contenedor.add(botonFac, BorderLayout.WEST);
        contenedor.add(botonLLam, BorderLayout.WEST);


        botonCli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               VistaClientes vistaCli=new VistaClientes();
               vistaCli.setControlador(controlador);
               vistaCli.setModelo(modelo);
                vistaCli.abrirVentanaClientes();
            }
        });

        ventanaPrincipal.setSize(400,400);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
