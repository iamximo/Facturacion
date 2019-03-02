package clases;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Gestor{

    private HashMap<String,Cliente> listaClientes;
    private HashMap<String,Factura> listaFacturas;

    public Gestor(){
        listaClientes= new HashMap<String, Cliente>();
        listaFacturas= new HashMap<String, Factura>();
    }

    public boolean altaCliente(Cliente nuevo){

        if (listaClientes.containsKey(nuevo.getNif())) return false;//el cliente ya existe

        listaClientes.put(nuevo.getNif(),nuevo);
        return true;
    }

    public boolean bajaCliente(String nif){

        if (listaClientes.containsKey(nif)){
            listaClientes.remove(nif);
            return true;
        }
        return false;
    }

    public boolean cambioTarifa(String nif, float nuevoPrecio){

        if(!listaClientes.containsKey(nif)) return false;

        listaClientes.get(nif).cambiarTarifa(nuevoPrecio);
        return true;
    }

    public Cliente getCliente( String nif){
        return listaClientes.get(nif);
    }

    public Collection<Cliente> getListaClientes(){
       return listaClientes.values();
    }

    public void altaLlamada(String nif, Llamada llamada){
        listaClientes.get(nif).addLlamada(llamada);
    }

    public List<Llamada> llamadasCliente(String nif){
        return listaClientes.get(nif).getListaLlamadas();
    }

    public boolean existeCodigoFactura(String codigo){
        return listaFacturas.containsKey(codigo);
    }

    public Factura emitirFactura(Factura factura, Cliente cliente, LocalDateTime fechaEmision){
        factura.setFechaEmision(fechaEmision);
        int minutos=0;
        for (Llamada llam : cliente.getListaLlamadas()){
            if(llam.getFecha().compareTo(factura.getInicioFacturacion())>0 && llam.getFecha().compareTo(factura.getFinFacturacion())<0){
                minutos+=llam.getDuracion();
            }
        }
        factura.setImporte(factura.getTarifa().getPrecio()*minutos);
        listaFacturas.put(factura.getCodigo(),factura);
        cliente.addFactura(factura);
        return factura;
    }

    public Factura getFactura(String codigo){
        return listaFacturas.get(codigo);
    }

    public List<Factura> getFacturasCliente(String nif){
        return listaClientes.get(nif).getListaFacturas();
    }

    public void generarClientesAleatorios(){
        GeneradorDatos gen = new GeneradorDatos();
        List<Cliente> lista = gen.listaClientesPrueba;
        for(Cliente cli:lista){
            listaClientes.put(cli.getNif(),cli);
        }

    }

}

