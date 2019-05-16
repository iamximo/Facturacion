package vista;

import modelo.InterfaceModelo;
import controlador.InterfaceControlador;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;


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



        JButton botonCli = new JButton("Menu clientes");
        JButton botonFac = new JButton("Menu facturas");
        JButton botonLLam = new JButton("Menu llamadas");
        JButton botonGuardar = new JButton("Guardar");
        JButton botonCargar = new JButton("Cargar datos");

        JPanel panelBotones=new JPanel();
        panelBotones.add(botonCli);
        panelBotones.add(botonFac);
        panelBotones.add(botonLLam);
        contenedor.add(panelBotones, BorderLayout.WEST);
        JPanel panelGuardarCargar = new JPanel();
        panelGuardarCargar.add(botonCargar);
        panelGuardarCargar.add(botonGuardar);
        contenedor.add(panelGuardarCargar,BorderLayout.PAGE_END);




        botonCli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               VistaClientes vistaCli=new VistaClientes();
               vistaCli.setControlador(controlador);
               vistaCli.setModelo(modelo);
                vistaCli.abrirVentanaClientes();
            }
        });

        botonFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaFacturas vistaFac =new VistaFacturas();
                vistaFac.setControlador(controlador);
                vistaFac.setModelo(modelo);
                vistaFac.abrirVentanaFacturas();
            }
        });

        botonLLam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaLlamadas vistaLlam = new VistaLlamadas();
                vistaLlam.setControlador(controlador);
                vistaLlam.setModelo(modelo);
                vistaLlam.abrirVentanaLlamadas();
            }
        });

        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectorCargar = new JFileChooser();
                //selectorCargar.setFileFilter(new FileNameExtensionFilter("bin"));
                switch (selectorCargar.showOpenDialog(new JFrame("Elige un fichero para cargar datos"))){
                    case JFileChooser.APPROVE_OPTION:
                        File ficheroCargar= selectorCargar.getSelectedFile();
                        controlador.cargarFich(ficheroCargar);
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    case JFileChooser.ERROR_OPTION:
                        JFrame ventana = new JFrame("Error");
                        Container contenedor = ventana.getContentPane();
                        JTextArea area= new JTextArea();
                        area.setText("Ha ocurido un error al intentar cargar un fichero");
                        JScrollPane scroll = new  JScrollPane(area);
                        contenedor.add(scroll);
                        ventana.pack();
                        ventana.setVisible(true);
                        break;
                }


            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectorGuardar = new JFileChooser();
                //selectorGuardar.setFileFilter(new FileNameExtensionFilter("bin"));
                switch (selectorGuardar.showSaveDialog(new JFrame("Elige un fichero para cargar datos"))){
                    case JFileChooser.APPROVE_OPTION:
                        File ficheroGuardar= selectorGuardar.getSelectedFile();
                        controlador.guardarFich(ficheroGuardar);
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    case JFileChooser.ERROR_OPTION:
                        JFrame ventana = new JFrame("Error");
                        Container contenedor = ventana.getContentPane();
                        JTextArea area= new JTextArea();
                        area.setText("Ha ocurido un error al intentar cargar un fichero");
                        JScrollPane scroll = new  JScrollPane(area);
                        contenedor.add(scroll);
                        ventana.pack();
                        ventana.setVisible(true);
                        break;
                }

            }
        });

        ventanaPrincipal.setSize(400,400);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
