package clases;

import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;
import excepciones.NoExisteFacturaException;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Gestor implements Serializable {

    private HashMap<String,Cliente> listaClientes;
    private HashMap<String,Factura> listaFacturas;
    FactoriaTarifa fabrica_tarifas=new FactoriaTarifa();

    public Gestor(){
        listaClientes= new HashMap<String, Cliente>();
        listaFacturas= new HashMap<String, Factura>();
    }

    public void altaCliente(Cliente nuevo) throws ClienteExistenteException {

        if (listaClientes.containsKey(nuevo.getNif())){
            throw new ClienteExistenteException();
        }
        listaClientes.put(nuevo.getNif(),nuevo);
    }

    public void bajaCliente(String nif) throws NoExisteClienteException{

        if (listaClientes.containsKey(nif))
            listaClientes.remove(nif);
        else throw new NoExisteClienteException();
    }

    public void cambioTarifa(String nif, float nuevoPrecio) throws NoExisteClienteException{

        if(!listaClientes.containsKey(nif)) throw new NoExisteClienteException();

        listaClientes.get(nif).cambiarTarifa(nuevoPrecio);
    }

    public Cliente getCliente( String nif) throws NoExisteClienteException {

        if (listaClientes.containsKey(nif))
            return listaClientes.get(nif);
        throw new NoExisteClienteException();
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
        int importe=0;
        for (Llamada llam : cliente.getListaLlamadas()){
            if(llam.getFecha().compareTo(factura.getInicioFacturacion())>=0 && llam.getFecha().compareTo(factura.getFinFacturacion())<=0){
                importe+=factura.getTarifa().getPrecioTarifa(llam);
            }
        }
        factura.setImporte(importe);
        listaFacturas.put(factura.getCodigo(),factura);
        cliente.addFactura(factura);
        return factura;
    }

    public Factura getFactura(String codigo) throws NoExisteFacturaException{
        if(!listaFacturas.containsKey(codigo)) throw new NoExisteFacturaException();
        return listaFacturas.get(codigo);
    }

    public List<Factura> getFacturasCliente(String nif)throws NoExisteClienteException{
        if(!listaClientes.containsKey(nif)) throw new NoExisteClienteException();
        return listaClientes.get(nif).getListaFacturas();
    }

    public void generarClientesAleatorios(){
        GeneradorDatos gen = new GeneradorDatos();
        List<Cliente> lista = gen.listaClientesPrueba;
        for(Cliente cli:lista){
            listaClientes.put(cli.getNif(),cli);
        }

    }

    public <T extends Fecha> List<T> estaEnElIntervalo(Collection<T> lista, LocalDateTime fechaInicio, LocalDateTime fechaFinal){
        List<T> listaResultado = new ArrayList<T>();
        for (T elemento : lista){
            if(elemento.getFecha().compareTo(fechaInicio)>=0 && elemento.getFecha().compareTo(fechaFinal)<=0)
                listaResultado.add(elemento);
        }
        return listaResultado;
    }

    public <T> String mostrarColleccion(Collection<T> coleccion){
        StringBuilder sb = new StringBuilder();
        for (T elem : coleccion){
            sb.append("-------------------------------------------\n");
            sb.append(elem);
            sb.append("\n-------------------------------------------\n");
        }
        return sb.toString();
    }

    public LocalDateTime pedirFecha(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Anyo: ");
        int year=scan.nextInt();
        System.out.println("Mes: ");
        int month=scan.nextInt();
        System.out.println("Dia: ");
        int day=scan.nextInt();
        System.out.println("Hora: ");
        int hour=scan.nextInt();
        System.out.println("Minuto: ");
        int min=scan.nextInt();
        return LocalDateTime.of(year,month,day,hour,min);
    }

    public void añadirTarifaHora(String nif, float precio, LocalTime ini,LocalTime fin) throws  NoExisteClienteException{
        if(!listaClientes.containsKey(nif)) throw new NoExisteClienteException();
        Cliente cli=listaClientes.get(nif);
        Tarifa tar_anterior=cli.getTarifa();
        TarifaHora tar=fabrica_tarifas.getTarifaHora(tar_anterior,precio,ini,fin);
        cli.setTarifa(tar);

    }

    public void añadirTarifaDia(String nif, float precio,DayOfWeek dia) throws  NoExisteClienteException{
        if(!listaClientes.containsKey(nif)) throw new NoExisteClienteException();
        Cliente cli=listaClientes.get(nif);
        Tarifa tar_anterior=cli.getTarifa();
        TarifaDia tar=fabrica_tarifas.getTarifaDia(tar_anterior,precio,dia);
        cli.setTarifa(tar);


    }



}

