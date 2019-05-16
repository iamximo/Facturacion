package vista;

import clases.Factura;
import clases.Llamada;
import controlador.InterfaceControlador;
import modelo.InterfaceModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class VistaLlamadas implements InterfaceVista {
    private InterfaceControlador controlador;
    private InterfaceModelo modelo;


    public void setControlador(InterfaceControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterfaceModelo modelo) {
        this.modelo = modelo;
    }

    public void abrirVentanaLlamadas(){
        JFrame ventana = new JFrame("Menu Llamadas");
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

        JPanel panelNumDestino = new JPanel();
        JTextField numDestino = new JTextField(6);
        JLabel numDestinoLabel = new JLabel("Número destino: ");
        panelNumDestino.add(numDestinoLabel);
        panelNumDestino.add(numDestino);
        contenedor.add(panelNumDestino);

        JPanel panelFechaHora = new JPanel();
        JLabel fechaHoraLabel = new JLabel("Fecha de la llamada:");
        panelFechaHora.add(fechaHoraLabel);
        JTextField dia = new JTextField(2);
        panelFechaHora.add(dia);
        panelFechaHora.add(new JLabel("/"));
        JTextField mes = new JTextField(2);
        panelFechaHora.add(mes);
        panelFechaHora.add(new JLabel("/"));
        JTextField anyo = new JTextField(4);
        panelFechaHora.add(anyo);
        panelFechaHora.add(new JLabel("  Hora de la llamada:"));
        JTextField hora = new JTextField(2);
        panelFechaHora.add(hora);
        panelFechaHora.add(new JLabel(":"));
        JTextField minuto = new JTextField(2);
        panelFechaHora.add(minuto);
        contenedor.add(panelFechaHora);

        JPanel panelDuracion = new JPanel();
        JLabel duracionLabel = new JLabel("Duración de la llamada:");
        panelDuracion.add(duracionLabel);
        JTextField  duracion = new JTextField(4);
        panelDuracion.add(duracion);
        contenedor.add(panelDuracion);

        JPanel panelBotones = new JPanel();

        JButton emitirFactura = new JButton("Dar de alta la llamada");
        panelBotones.add(emitirFactura);
        contenedor.add(panelBotones);

        contenedor.add(new JSeparator());


        emitirFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(anyo.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText()),Integer.parseInt(hora.getText()),Integer.parseInt(minuto.getText()));
                Llamada nuevaLlamada = new Llamada(numDestino.getText(),fecha,Float.parseFloat(duracion.getText()));
                controlador.anyadirLlamada(nif.getText(),nuevaLlamada);
            }
        });

        JPanel consultarLlamcli=new JPanel();
        JTextField dni = new JTextField(9);
        JLabel dniLabel = new JLabel("Consultar las llamadas de un cliente(NIF):");
        consultarLlamcli.add(dniLabel);
        consultarLlamcli.add(dni);
        JButton buttonConsultarLlam = new JButton("Consultar");
        consultarLlamcli.add(buttonConsultarLlam);
        contenedor.add(consultarLlamcli);

        buttonConsultarLlam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Llamadas cliente");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                area.setText(controlador.getLlamadasCliente(dni.getText()));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });

        JPanel panelFechaConsulta = new JPanel();
        JTextField nifconsultaLlamInter = new JTextField(10);
        JLabel fechaLabelCons = new JLabel("Consultar llamadas de un cliente entre dos fechas (NIF): ");
        panelFechaConsulta.add(fechaLabelCons);
        panelFechaConsulta.add(nifconsultaLlamInter);
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
                JFrame ventanaListado = new JFrame("Listado llamadas en el intervalo");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                LocalDateTime fechI = LocalDateTime.of(Integer.parseInt(anyoiniInter.getText()),Integer.parseInt(mesiniInter.getText()),Integer.parseInt(diainiInter.getText()),0,0,0);
                LocalDateTime fechF = LocalDateTime.of(Integer.parseInt(anyofinInter.getText()),Integer.parseInt(mesfinInter.getText()),Integer.parseInt(diafinInter.getText()),0,0,0);

                area.setText(controlador.llamadasIntervalo(nifconsultaLlamInter.getText(),fechI,fechF));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });
    }
}
