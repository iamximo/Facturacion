
import clases.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;


public class TarifaTest {

    FactoriaTarifa fabrica=new FactoriaTarifa();

    // Tarifa basica=20
    Tarifa tar1=fabrica.getTarifaBasica(20);

    //Tarifa basica=0
    Tarifa tar2=fabrica.getTarifaBasica(0);

    //Tarifa basica=20 - TarifaDia=5
    TarifaDia tar3=fabrica.getTarifaDia(tar1,5,LocalDate.now().getDayOfWeek());

    //Tarifa basica=20 - TarifaDia=28
    TarifaDia tar4=fabrica.getTarifaDia(tar1,28,LocalDate.now().getDayOfWeek());


    //Tarifa basica=20 - TarifaHora=15
    TarifaHora tar5=fabrica.getTarifaHora(tar1,15, LocalTime.now(),LocalTime.now().plusHours(1));

    //Tarifa basica=20 - TarifaDia=5 - TarifaHora=2
    TarifaHora tar6=fabrica.getTarifaHora(tar3,2,LocalTime.now(),LocalTime.now().plusHours(1));

    //Tarifa basica=20 - TarifaDia=5 - TarifaHora=6
    TarifaHora tar7=fabrica.getTarifaHora(tar3,6,LocalTime.now(),LocalTime.now().plusHours(1));

    //Tarifa basica=20 - TarifaDia=4
    TarifaDia tar8=fabrica.getTarifaDia(tar1,4,LocalDate.ofYearDay(2019,1).getDayOfWeek());


    @Test
    public void getPrecioTest(){
        assertEquals(20,tar1.getPrecio(),0);
        assertEquals(0,tar2.getPrecio(),0);

    }

    @Test
    public void getPrecioTarifaTest(){
        Llamada lla1=new Llamada("67", LocalDateTime.now(),6);
        Llamada lla2=new Llamada("67", LocalDateTime.now().plusHours(-1),6);
        Llamada lla3=new Llamada("67", LocalDateTime.of(2019,1,1,0,0),6);

        assertEquals(5*6,tar3.getPrecioTarifa(lla1),0); // Se aplica tarifa de dia
        assertEquals(20*6,tar4.getPrecioTarifa(lla1),0); // Se aplica tarifa basica
        assertEquals(15*6,tar5.getPrecioTarifa(lla1),0); // Se aplica tarifa hora
        assertEquals(20*6,tar5.getPrecioTarifa(lla2),0); // Se aplica tarifa basica

        assertEquals(2*6,tar6.getPrecioTarifa(lla1),0); // Se aplica tarifa hora
        assertEquals(5*6,tar7.getPrecioTarifa(lla1),0); // Se aplica tarifa de dia

        assertEquals(20*6,tar8.getPrecioTarifa(lla1),0); // Se aplica tarifa basica
        assertEquals(4*6,tar8.getPrecioTarifa(lla3),0); // Se aplica tarifa de dia





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
