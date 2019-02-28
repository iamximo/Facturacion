package clases;

import es.uji.www.GeneradorDatosINE;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class GeneradorDatos
{
    ArrayList<Cliente> listaClientesPrueba = new ArrayList();
    GeneradorDatosINE gen = new GeneradorDatosINE();
    Cliente cli;

    public GeneradorDatos() {
        generar();
    }


    private void generar() { for (int i = 0; i < 50; i++) {
        String prov = gen.getProvincia();
        String nombre = gen.getNombre();
        Direccion dir = new Direccion(12004 + i, prov, gen.getPoblacion(prov));
        String email = nombre + i + "@gmail.com";
        LocalDateTime fecha = LocalDateTime.now();
        if (i % 2 == 0) {
            cli = new Cliente(nombre, gen.getNIF(), dir, email, fecha, i);
        }
        else {
            cli = new Particular(nombre, gen.getApellido(), gen.getNIF(), dir, email, fecha, i);
        }

        listaClientesPrueba.add(cli);
    }
    }

    public ArrayList<Cliente> getListaClientesPrueba() {
        return listaClientesPrueba;
    }

    /*
    public static void main(String[] args) {
        GeneradorDatos g = new GeneradorDatos();
        g.generar();
        for (Cliente cl : g.listaClientesPrueba) {
            System.out.println(cl.toString());
        }
    }*/

}
