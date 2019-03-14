
import clases.*;
import excepciones.ClienteExistenteException;
import excepciones.NoExisteClienteException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GestorTest {

    private Gestor miGestor;

    @Before
    public  void reset(){
        miGestor=new Gestor();
    }

    Cliente cli1= new Cliente("Juan","20914825U",null,"juan@uji.es",null,2);
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





}


