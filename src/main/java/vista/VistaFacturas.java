package vista;

import clases.Direccion;
import clases.Factura;
import controlador.InterfaceControlador;
import modelo.InterfaceModelo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VistaFacturas implements InterfaceVista {
    private InterfaceControlador controlador;
    private InterfaceModelo modelo;


    public void setControlador(InterfaceControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterfaceModelo modelo) {
        this.modelo = modelo;
    }

    public void abrirVentanaFacturas(){
        JFrame ventana = new JFrame("Menu Facturas");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new GridLayout(20,5));

        creaMenu(contenedor);



        ventana.pack();
        ventana.setVisible(true);
    }


    public void  creaMenu(Container contenedor){

        JPanel panelNif = new JPanel();
        JTextField nif = new JTextField(9);
        JLabel nifLabel = new JLabel("NIF: ");
        panelNif.add(nifLabel);
        panelNif.add(nif);
        contenedor.add(panelNif);

        JPanel panelCodigo = new JPanel();
        JTextField codigoFac = new JTextField(6);
        JLabel codFacLabel = new JLabel("Codigo factura: ");
        panelCodigo.add(codFacLabel);
        panelCodigo.add(codigoFac);
        contenedor.add(panelCodigo);

        JPanel panelFechaIni = new JPanel();
        JLabel FechaIniLabel = new JLabel("Fecha Inicio");
        panelFechaIni.add(FechaIniLabel);
        JTextField diaIni = new JTextField(2);
        panelFechaIni.add(diaIni);
        panelFechaIni.add(new JLabel("/"));
        JTextField mesIni = new JTextField(2);
        panelFechaIni.add(mesIni);
        panelFechaIni.add(new JLabel("/"));
        JTextField anyoIni = new JTextField(4);
        panelFechaIni.add(anyoIni);
        contenedor.add(panelFechaIni);

        JPanel panelFechaFin = new JPanel();
        JLabel FechaFinLabel = new JLabel("Fecha Fin");
        panelFechaFin.add(FechaFinLabel);
        JTextField diaFin = new JTextField(2);
        panelFechaFin.add(diaFin);
        panelFechaFin.add(new JLabel("/"));
        JTextField mesFin = new JTextField(2);
        panelFechaFin.add(mesFin);
        panelFechaFin.add(new JLabel("/"));
        JTextField anyoFin = new JTextField(4);
        panelFechaFin.add(anyoFin);
        contenedor.add(panelFechaFin);

        JPanel panelBotones = new JPanel();

        JButton emitirFactura = new JButton("Emitir factura");
        panelBotones.add(emitirFactura);
        contenedor.add(panelBotones);

        contenedor.add(new JSeparator());


        emitirFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime fechaIni = LocalDateTime.of(Integer.parseInt(anyoIni.getText()),Integer.parseInt(mesIni.getText()),Integer.parseInt(diaIni.getText()),0,0);
                LocalDateTime fechaFin = LocalDateTime.of(Integer.parseInt(anyoFin.getText()),Integer.parseInt(mesFin.getText()),Integer.parseInt(diaFin.getText()),0,0);
                Factura nuevaFac = new Factura(codigoFac.getText(),controlador.getObjetoCliente(nif.getText()).getTarifa(),fechaIni,fechaFin);
                controlador.emitirFactura(nuevaFac,nif.getText());
            }
        });

        JPanel consultarFac=new JPanel();
        JTextField codFac = new JTextField(10);
        JLabel codFactuLabel = new JLabel("Consultar datos de una factura (Código Factura):");
        consultarFac.add(codFactuLabel);
        consultarFac.add(codFac);
        JButton buttonConsultarFac = new JButton("Consultar");
        consultarFac.add(buttonConsultarFac);
        contenedor.add(consultarFac);

        buttonConsultarFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Datos factura");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                area.setText(controlador.getFactura(codFac.getText()));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });

        JPanel consultarFacturasNif=new JPanel();
        JTextField nifConsultarNif = new JTextField(10);
        JLabel nifConsultarFacturasNifLabel = new JLabel("Consultar facturas de un cliente (NIF):");
        consultarFacturasNif.add(nifConsultarFacturasNifLabel);
        consultarFacturasNif.add(nifConsultarNif);
        JButton buttonConsultarFacturasNif = new JButton("Consultar");
        consultarFacturasNif.add(buttonConsultarFacturasNif);
        contenedor.add(consultarFacturasNif);


        buttonConsultarFacturasNif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Listado facturas cliente");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                area.setText(controlador.getFacturasCliente(nifConsultarNif.getText()));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });

        JPanel panelFechaConsulta = new JPanel();
        JTextField nifconsultaFacInter = new JTextField(10);
        JLabel fechaLabelCons = new JLabel("Consultar facturas cliente entre dos fechas (NIF): ");
        panelFechaConsulta.add(fechaLabelCons);
        panelFechaConsulta.add(nifconsultaFacInter);
        JLabel FechaLabelIniInter = new JLabel("Fecha ini");
        panelFechaConsulta.add(FechaLabelIniInter);
        JTextField diainiInter = new JTextField(2);
        panelFechaConsulta.add(diainiInter);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField mesiniInter = new JTextField(2);
        panelFechaConsulta.add(mesiniInter);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField anyoiniInter = new JTextField(4);
        panelFechaConsulta.add(anyoiniInter);

        JLabel FechaLabelFinInter = new JLabel("Fecha fin");
        panelFechaConsulta.add(FechaLabelFinInter);
        JTextField diafinInter= new JTextField(2);
        panelFechaConsulta.add(diafinInter);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField mesfinInter = new JTextField(2);
        panelFechaConsulta.add(mesfinInter);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField anyofinInter = new JTextField(4);
        panelFechaConsulta.add(anyofinInter);
        JButton buttonConsultarFechaInter = new JButton("Consultar");
        panelFechaConsulta.add(buttonConsultarFechaInter);
        contenedor.add(panelFechaConsulta);



        buttonConsultarFechaInter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Listado facturas en un intervalo");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                LocalDateTime fechI = LocalDateTime.of(Integer.parseInt(anyoiniInter.getText()),Integer.parseInt(mesiniInter.getText()),Integer.parseInt(diainiInter.getText()),0,0,0);
                LocalDateTime fechF = LocalDateTime.of(Integer.parseInt(anyofinInter.getText()),Integer.parseInt(mesfinInter.getText()),Integer.parseInt(diafinInter.getText()),0,0,0);

                area.setText(controlador.getFacturasIntervalo(fechI,fechF, nifconsultaFacInter.getText()));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });
    }



}
