package modelo;

import clases.Cliente;
import clases.Factura;
import clases.Llamada;
import clases.TarifaDia;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface InterfaceModelo {

    void altaCliente(Cliente cli);

    void bajaCliente(String nif);

    void añadirTarifaDia(String nif, float precio, int dia);

    void añadirTarifaHora(String nif, float precio, int ini, int fin);

    String getListaClientes();

    String getDatosCliente(String nif);

    String ClientesEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal);

    void generarClientesAutomaticos();

    Cliente getObjetoCliente(String nif);

    void emitirFactura(Factura factura, String nif);

    String getFactura(String codFac);

    String getFacturasCliente(String nif);

    String getFacturasIntervalo(LocalDateTime fechaIni, LocalDateTime fechaFin, String nif);

    void anyadirLlamada(String nif, Llamada llamada);

    String getLlamadasCliente(String nif);

    String llamadasIntervalo(String nif, LocalDateTime fechaIni, LocalDateTime fechaFin);

    void cargarFich(File fich);

    void guardarFich(File fich);

}

