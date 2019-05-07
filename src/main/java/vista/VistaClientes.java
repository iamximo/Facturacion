package vista;

import controlador.InterfaceControlador;
import modelo.InterfaceModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JTextField nombre = new JTextField(20);
        JLabel nombreLabel = new JLabel("Nombre: ");



        contenedor.add(nombreLabel);
        contenedor.add(nombre);

        JTextField apellidos = new JTextField(20);
        JLabel apellidosLabel = new JLabel("Apellidos: ");
        contenedor.add(apellidosLabel);
        contenedor.add(apellidos);

        JTextField nif = new JTextField(20);
        JLabel nifLabel = new JLabel("NIF: ");
        contenedor.add(nifLabel);
        contenedor.add(nif);

        JTextField codPost = new JTextField(20);
        JLabel codPostLabel = new JLabel("Codigo postal: ");
        contenedor.add(codPostLabel);
        contenedor.add(codPost);

        JTextField provincia = new JTextField(20);
        JLabel provinciaLabel = new JLabel("Provincia: ");
        contenedor.add(provinciaLabel);
        contenedor.add(provincia);

        JTextField poblacion = new JTextField(20);
        JLabel poblacionLabel = new JLabel("Poblacion: ");
        contenedor.add(poblacionLabel);
        contenedor.add(poblacion);

        JTextField email = new JTextField(20);
        JLabel emailLabel = new JLabel("Email: ");
        contenedor.add(emailLabel);
        contenedor.add(email);

        JTextField precio = new JTextField(20);
        JLabel precioLabel = new JLabel("Precio: ");
        contenedor.add(precioLabel);
        contenedor.add(precio);

        JTextField dia = new JTextField(2);
        JLabel diaLabel = new JLabel("Dia: ");
        contenedor.add(diaLabel);
        contenedor.add(dia);

        JTextField mes = new JTextField(2);
        JLabel mesLabel = new JLabel("Mes: ");
        contenedor.add(mesLabel);
        contenedor.add(mes);

        JTextField año = new JTextField(4);
        JLabel añoLabel = new JLabel("Año: ");
        contenedor.add(añoLabel);
        contenedor.add(año);



        JButton altaEmpresa = new JButton("Alta Empresa");
        contenedor.add(altaEmpresa, BorderLayout.WEST);
        JButton altaParticular = new JButton("Alta Particular");
        contenedor.add(altaParticular, BorderLayout.WEST);

        JTextField nifBorrado = new JTextField(20);
        JLabel nifBorradoLabel = new JLabel("NIF: ");
        contenedor.add(nifLabel);
        contenedor.add(nif);
        JButton borrarCliente = new JButton("Borrar");
        contenedor.add(borrarCliente);


        altaEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevoCliente();
            }
        });


        ventana.setSize(600,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }


}
