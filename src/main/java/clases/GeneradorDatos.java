package clases;

import es.uji.www.GeneradorDatosINE;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class GeneradorDatos implements Serializable
{
    ArrayList<Cliente> listaClientesPrueba = new ArrayList();
    GeneradorDatosINE gen = new GeneradorDatosINE();
    Cliente cli;
    FactoriaCliente fabrica=new FactoriaCliente();

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
            cli=fabrica.getEmpresaNuevo(nombre,gen.getNIF(),dir,email,fecha,i);


        }
        else {
            cli=fabrica.getParticularNuevo(nombre,gen.getApellido(),gen.getNIF(),dir,email,fecha,i);
        }

        listaClientesPrueba.add(cli);
    }
    }

    public ArrayList<Cliente> getListaClientesPrueba() {
        return listaClientesPrueba;
    }


}
