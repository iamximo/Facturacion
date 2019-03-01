import clases.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

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
        miGestor.altaCliente(cli1);
        assertEquals(miGestor.getListaClientes().size(),1,0);
        assertEquals(miGestor.getListaClientes().contains(cli1),true);
    }

    @Test
    public void bajaClienteTest(){
        miGestor.altaCliente(cli1);
        assertEquals(miGestor.getListaClientes().size(),1,0);
        assertEquals(miGestor.bajaCliente("20914825U"),true);
        assertEquals(miGestor.bajaCliente("20914825U"),false);
        assertEquals(miGestor.getListaClientes().size(),0,0);
        assertEquals(miGestor.getListaClientes().contains(cli1),false);

    }

    @Test
    public void cambioTarifaTest(){
        miGestor.altaCliente(cli1);
        assertEquals(miGestor.getCliente("20914825U").getTarifa().getPrecio(),2,0);
        miGestor.cambioTarifa("20914825U",1);
        assertEquals(miGestor.getCliente("20914825U").getTarifa().getPrecio(),1,0);
    }


    @Test
    public void altaLlamadaTest(){
        miGestor.altaCliente(cli1);
        assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().size(),0,0);
        miGestor.getCliente("20914825U").addLlamada(llam);
        assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().size(),1,0);
        assertEquals(miGestor.getCliente("20914825U").getListaLlamadas().get(0),llam);
    }





}
