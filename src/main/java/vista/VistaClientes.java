package vista;

import clases.Direccion;
import controlador.InterfaceControlador;
import modelo.InterfaceModelo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VistaClientes implements InterfaceVista {
    private InterfaceControlador controlador;
    private InterfaceModelo modelo;


    public void setControlador(InterfaceControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(InterfaceModelo modelo) {
        this.modelo = modelo;
    }

    public void abrirVentanaClientes(){
        JFrame ventana = new JFrame("Menu clientes");
        Container contenedor = ventana.getContentPane();
        contenedor.setLayout(new GridLayout(20,5));

        creaMenu(contenedor);



        ventana.pack();
        ventana.setVisible(true);
    }


    public void  creaMenu(Container contenedor){

        JPanel panelNombre = new JPanel();
        JTextField nombre = new JTextField(15);
        JLabel nombreLabel = new JLabel("Nombre: ");
        panelNombre.add(nombreLabel);
        panelNombre.add(nombre);
        panelNombre.setLayout(new FlowLayout());
        contenedor.add(panelNombre);

        JPanel panelApellidos = new JPanel();
        JTextField apellidos = new JTextField(15);
        JLabel apellidosLabel = new JLabel("Apellidos: ");
        panelApellidos.add(apellidosLabel);
        panelApellidos.add(apellidos);
        contenedor.add(panelApellidos);

        JPanel panelNif = new JPanel();
        JTextField nif = new JTextField(9);
        JLabel nifLabel = new JLabel("NIF: ");
        panelNif.add(nifLabel);
        panelNif.add(nif);
        contenedor.add(panelNif);



        JPanel panelCodPost = new JPanel();
        JTextField codPost = new JTextField(5);
        JLabel codPostLabel = new JLabel("Codigo postal: ");
        panelCodPost.add(codPostLabel);
        panelCodPost.add(codPost);
        contenedor.add(panelCodPost);


        JPanel panelProvincia = new JPanel();
        JTextField provincia = new JTextField(15);
        JLabel provinciaLabel = new JLabel("Provincia: ");
        panelProvincia.add(provinciaLabel);
        panelProvincia.add(provincia);
        contenedor.add(panelProvincia);


        JPanel panelPoblacion = new JPanel();
        JTextField poblacion = new JTextField(15);
        JLabel poblacionLabel = new JLabel("Poblacion: ");
        panelPoblacion.add(poblacionLabel);
        panelPoblacion.add(poblacion);
        contenedor.add(panelPoblacion);



        JPanel panelEmail = new JPanel();
        JTextField email = new JTextField(20);
        JLabel emailLabel = new JLabel("Email: ");
        panelEmail.add(emailLabel);
        panelEmail.add(email);
        contenedor.add(panelEmail);


        JPanel panelPrecio = new JPanel();
        JTextField precio = new JTextField(6);
        JLabel precioLabel = new JLabel("Precio: ");
        panelPrecio.add(precioLabel);
        panelPrecio.add(precio);
        contenedor.add(panelPrecio);

        JPanel panelFecha = new JPanel();
        JLabel FechaLabel = new JLabel("Fecha");
        panelFecha.add(FechaLabel);
        JTextField dia = new JTextField(2);
        panelFecha.add(dia);
        panelFecha.add(new JLabel("/"));
        JTextField mes = new JTextField(2);
        panelFecha.add(mes);
        panelFecha.add(new JLabel("/"));
        JTextField año = new JTextField(4);
        panelFecha.add(año);
        contenedor.add(panelFecha);

        JPanel panelBotones = new JPanel();


        JButton altaEmpresa = new JButton("Alta Empresa");
        panelBotones.add(altaEmpresa);
        JButton altaParticular = new JButton("Alta Particular");
        panelBotones.add(altaParticular);
        contenedor.add(panelBotones);

        contenedor.add(new JSeparator());


        altaEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direccion dir=new Direccion(Integer.parseInt(codPost.getText()),provincia.getText(),poblacion.getText());
                LocalDateTime fec=LocalDateTime.of(Integer.parseInt(año.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText()),0,0);
                controlador.altaEmpresa(nombre.getText(),nif.getText(),dir,email.getText(),fec,Integer.parseInt(precio.getText()));
            }
        });

        altaParticular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Direccion dir=new Direccion(Integer.parseInt(codPost.getText()),provincia.getText(),poblacion.getText());
                LocalDateTime fec=LocalDateTime.of(Integer.parseInt(año.getText()),Integer.parseInt(mes.getText()),Integer.parseInt(dia.getText()),0,0);
                controlador.altaParticular(nombre.getText(),apellidos.getText(),nif.getText(),dir,email.getText(),fec,Integer.parseInt(precio.getText()));
            }
        });


        JPanel panelBorradoCli=new JPanel();

        JTextField nifBorrado = new JTextField(10);
        JLabel nifBorradoLabel = new JLabel("BORRAR CLIENTE (NIF): ");
        panelBorradoCli.add(nifBorradoLabel);
        panelBorradoCli.add(nifBorrado);
        JButton borrarCliente = new JButton("Borrar");
        panelBorradoCli.add(borrarCliente);
        contenedor.add(panelBorradoCli);


       borrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.bajaCliente(nifBorrado.getText());
            }
        });


        JPanel panelTarifaDia=new JPanel();
        JTextField nifTarifaDia = new JTextField(10);
        JLabel nifTarifaDiaLabel = new JLabel("Añadir tarifa dia (NIF) ");
        panelTarifaDia.add(nifTarifaDiaLabel);
        panelTarifaDia.add(nifTarifaDia);
        JTextField precioTarifaDia = new JTextField(5);
        JLabel precioTarifaDiaLabel = new JLabel("Precio:");
        panelTarifaDia.add(precioTarifaDiaLabel);
        panelTarifaDia.add(precioTarifaDia);
        JTextField diaTarifaDia = new JTextField(2);
        JLabel diaTarifaDiaLabel = new JLabel("Dia(1-7):");
        panelTarifaDia.add(diaTarifaDiaLabel);
        panelTarifaDia.add(diaTarifaDia);
        JButton añadirTarifaDia = new JButton("Añadir");
        panelTarifaDia.add(añadirTarifaDia);
        contenedor.add(panelTarifaDia);


        añadirTarifaDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.añadirTarifaDia(nifTarifaDia.getText(),Integer.parseInt(precioTarifaDia.getText()),Integer.parseInt(diaTarifaDia.getText()));
            }
        });


        JPanel panelTarifaHora=new JPanel();
        JTextField nifTarifaHora = new JTextField(10);
        JLabel nifTarifaHoraLabel = new JLabel("Añadir tarifa hora (NIF) ");
        panelTarifaHora.add(nifTarifaHoraLabel);
        panelTarifaHora.add(nifTarifaHora);
        JTextField precioTarifaHora = new JTextField(5);
        JLabel precioTarifaHoraLabel = new JLabel("Precio:");
        panelTarifaHora.add(precioTarifaHoraLabel);
        panelTarifaHora.add(precioTarifaHora);
        JTextField HorainiTarifaHora = new JTextField(2);
        JLabel HorainiTarifaHoraLabel = new JLabel("Hora ini:");
        panelTarifaHora.add(HorainiTarifaHoraLabel);
        panelTarifaHora.add(HorainiTarifaHora);
        JTextField HorafinTarifaHora = new JTextField(2);
        JLabel HorafinTarifaHoraLabel = new JLabel("Hora fin:");
        panelTarifaHora.add(HorafinTarifaHoraLabel);
        panelTarifaHora.add(HorafinTarifaHora);
        JButton añadirTarifaHora = new JButton("Añadir");
        panelTarifaHora.add(añadirTarifaHora);
        contenedor.add(panelTarifaHora);

        añadirTarifaHora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.añadirTarifaHora(nifTarifaHora.getText(),Integer.parseInt(precioTarifaHora.getText()),Integer.parseInt(HorainiTarifaHora.getText()),Integer.parseInt(HorafinTarifaHora.getText()));
            }
        });


        JPanel consultarTodosClientesPanel = new JPanel();
        JButton consultarTodosClientes = new JButton("Consultar todos los clientes");
        consultarTodosClientesPanel.add(consultarTodosClientes);
        contenedor.add(consultarTodosClientesPanel);

        consultarTodosClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Listado clientes");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                area.setText(controlador.getListaClientes());
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });



        JPanel consultarNif=new JPanel();
        JTextField nifConsultarNif = new JTextField(10);
        JLabel nifConsultarNifLabel = new JLabel("Consultar datos clientes (NIF):");
        consultarNif.add(nifConsultarNifLabel);
        consultarNif.add(nifConsultarNif);
        JButton buttonConsultarNif = new JButton("Consultar");
        consultarNif.add(buttonConsultarNif);
        contenedor.add(consultarNif);

        buttonConsultarNif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Listado clientes NIF");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                area.setText(controlador.getCliente(nifConsultarNif.getText()));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });


        JPanel panelFechaConsulta = new JPanel();
        JLabel fechaLabelCons = new JLabel("Consultar clientes entre fechas: ");
        panelFechaConsulta.add(fechaLabelCons);
        JLabel FechaLabelIni = new JLabel("Fecha ini");
        panelFechaConsulta.add(FechaLabelIni);
        JTextField diaini = new JTextField(2);
        panelFechaConsulta.add(diaini);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField mesini = new JTextField(2);
        panelFechaConsulta.add(mesini);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField añoini = new JTextField(4);
        panelFechaConsulta.add(añoini);

        JLabel FechaLabelFin = new JLabel("Fecha fin");
        panelFechaConsulta.add(FechaLabelFin);
        JTextField diafin= new JTextField(2);
        panelFechaConsulta.add(diafin);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField mesfin = new JTextField(2);
        panelFechaConsulta.add(mesfin);
        panelFechaConsulta.add(new JLabel("/"));
        JTextField añofin = new JTextField(4);
        panelFechaConsulta.add(añofin);
        JButton buttonConsultarFecha = new JButton("Consultar");
        panelFechaConsulta.add(buttonConsultarFecha);
        contenedor.add(panelFechaConsulta);



        buttonConsultarFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventanaListado = new JFrame("Listado clientes FECHA");
                Container contenedor = ventanaListado.getContentPane();
                JTextArea area= new JTextArea();
                LocalDateTime fechI = LocalDateTime.of(Integer.parseInt(añoini.getText()),Integer.parseInt(mesini.getText()),Integer.parseInt(diaini.getText()),0,0,0);
                LocalDateTime fechF = LocalDateTime.of(Integer.parseInt(añofin.getText()),Integer.parseInt(mesfin.getText()),Integer.parseInt(diafin.getText()),0,0,0);

                area.setText(controlador.clientesIntervalo(fechI,fechF));
                JScrollPane scroll = new  JScrollPane(area);
                contenedor.add(scroll);
                ventanaListado.pack();
                ventanaListado.setVisible(true);
            }

        });


        JPanel panelCliAutomaticos = new JPanel();
        JButton buttonPanelCliAutomaticos = new JButton("Dar de alta clientes automaticos");
        panelCliAutomaticos.add(buttonPanelCliAutomaticos);
        contenedor.add(panelCliAutomaticos);

        buttonPanelCliAutomaticos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controlador.generarClientesAleatorios();
            }

        });





    }



}
