
import clases.*;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GestorTest {

    private Gestor miGestor;

    @Before
    public  void reset(){
        miGestor=new Gestor();
    }

    LocalDateTime fecha = LocalDateTime.of(1999,11,6,10,00);
    LocalDateTime fecha2 = LocalDateTime.of(1999,11,7,10,00);

    FactoriaCliente fabrica=new FactoriaCliente();
    Cliente cli1= fabrica.getEmpresaNuevo("Juan","20914825U",null,"juan@uji.es",fecha,2);
    Cliente cli2= fabrica.getEmpresaNuevo("Juana","20914825Us",null,"juan@uji.es",fecha2,2);
    Llamada llam=new Llamada("675672891",null,3);


    @Test
    public void altaClienteTest(){
        assertEquals(miGestor.getListaClientes().size(),0,0);
        try {
            miGestor.altaCliente(cli1);
        }
        catch (ClienteExistenteException a){}

        try {
            miGestor.altaCliente(cli1);
            fail("El cliente existe y no trata la excepcion");
        }catch (ClienteExistenteException e){

        }
        assertEquals(miGestor.getListaClientes().size(),1,0);
        assertEquals(miGestor.getListaClientes().contains(cli1),true);
    }

    @Test
    public void bajaClienteTest(){
        try {
            miGestor.altaCliente(cli1);
        }catch (ClienteExistenteException e){

        }
        assertEquals(miGestor.getListaClientes().size(),1,0);
        try{
            miGestor.bajaCliente("20914825U");
        }catch (NoExisteClienteException e){
            fail();
        }
        try{
            miGestor.bajaCliente("20914825U");
            fail();
        }catch (NoExisteClienteException e){

        }
        assertEquals(miGestor.getListaClientes().size(),0,0);
        assertEquals(miGestor.getListaClientes().contains(cli1),false);

    }

    @Test
    public void cambioTarifaTest(){
        try {
            miGestor.altaCliente(cli1);
        }catch (ClienteExistenteException e){

        }
        try {
            assertEquals(miGestor.getCliente("20914825U").getTarifa().getPrecio(), 2, 0);
            miGestor.cambioTarifa("20914825U", 1);
            assertEquals(miGestor.getCliente("20914825U").getTarifa().getPrecio(), 1, 0);
        }catch (NoExisteClienteException e){
            fail();
        }
    }


    @Test
    public void altaLlamadaTest(){
        try {
            miGestor.altaCliente(cli1);

        }catch (ClienteExistenteException e){

        }
        try {
            assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().size(), 0, 0);
            miGestor.getCliente("20914825U").addLlamada(llam);
            assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().size(), 1, 0);
            assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().get(0), llam);
        }catch (NoExisteClienteException e){
            fail();
        }
    }

    @Test
    public void estaEnElIntervaloTest(){
        try {
            miGestor.altaCliente(cli1);
        }catch(ClienteExistenteException e){}
        try {
            miGestor.altaCliente(cli2);
        }catch(ClienteExistenteException e){}

        LocalDateTime fecha_ref = LocalDateTime.of(1999,11,6,00,00);
        LocalDateTime fecha_ref2 = LocalDateTime.of(1999,11,6,23,00);
        LocalDateTime fecha_ref3 = LocalDateTime.of(1999,12,8,23,00);
        assertEquals(miGestor.estaEnElIntervalo(miGestor.getListaClientes(),fecha_ref,fecha_ref2).size(),1,0);
        assertEquals(miGestor.estaEnElIntervalo(miGestor.getListaClientes(),fecha_ref,fecha_ref3).size(),2,0);

    }





}


