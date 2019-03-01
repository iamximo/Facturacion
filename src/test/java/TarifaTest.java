
import clases.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TarifaTest {

    Tarifa tar1=new Tarifa(20);
    Tarifa tar2=new Tarifa(0);

    @Test
    public void getPrecioTest(){
        assertEquals(20,tar1.getPrecio(),0);
        assertEquals(0,tar2.getPrecio(),0);
    }

    @Test
    public void setPrecioTest(){
        assertEquals(20,tar1.getPrecio(),0);
        assertEquals(0,tar2.getPrecio(),0);
        tar1.setPrecio(200);
        tar2.setPrecio((float) 16.9);
        assertEquals(200,tar1.getPrecio(),0);
        assertEquals((float)16.9,tar2.getPrecio(),0);


    }
}
