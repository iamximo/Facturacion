
import clases.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class TarifaTest {

    Tarifa tar1=new TarifaBasica(20);
    Tarifa tar2=new TarifaBasica(0);
    TarifaDia tar3=new TarifaDia(tar1,5,LocalDate.now().getDayOfWeek());
    TarifaDia tar4=new TarifaDia(tar1,21,LocalDate.now().getDayOfWeek());


    @Test
    public void getPrecioTest(){
        assertEquals(20,tar1.getPrecio(),0);
        assertEquals(0,tar2.getPrecio(),0);
    }

    @Test
    public void getPrecioTarifaTest(){
        Llamada lla1=new Llamada("67", LocalDateTime.now(),6);

        assertEquals(5*6,tar3.getPrecioTarifa(lla1),0);
        assertEquals(20*6,tar4.getPrecioTarifa(lla1),0);

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
