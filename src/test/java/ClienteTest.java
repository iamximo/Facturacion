
import clases.*;
import clases.GeneradorDatos;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.*;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    LocalDateTime fecha = LocalDateTime.of(1999,11,06,10,00);

    Direccion dir=new Direccion(12000, "Castellon","Castellon");



    Cliente cli1= new Cliente("Juan","20914825U",dir,"juan@uji.es",fecha,2);
    Cliente cli2= new Cliente("Lourdes","53742927Y",dir,"lourdes@uji.es",fecha,5);
    Cliente cli3= new Cliente("Mario","24653725S",dir,"mario@uji.es",fecha,6);


    @Test
    public void getNombreTest(){
        assertEquals("Juan",cli1.getNombre());
        assertEquals("Lourdes",cli2.getNombre());
        assertEquals("Mario",cli3.getNombre());

    }

    @Test
    public void getNifTest(){
        assertEquals("20914825U",cli1.getNif());
        assertEquals("53742927Y",cli2.getNif());
        assertEquals("24653725S",cli3.getNif());
    }

    @Test
    public void getEmailTest(){
        assertEquals("juan@uji.es",cli1.getEmail());
        assertEquals("lourdes@uji.es",cli2.getEmail());
        assertEquals("mario@uji.es",cli3.getEmail());
    }


    @Test
    public void getDireccionTest(){
        assertEquals(dir,cli1.getDireccion());
        assertEquals(dir,cli2.getDireccion());
        assertEquals(dir,cli3.getDireccion());
    }

    @Test
    public void getTarifaTest(){
        assertEquals(2,cli1.getTarifa().getPrecio(),0);
        assertEquals(5,cli2.getTarifa().getPrecio(),0);
        assertEquals(6,cli3.getTarifa().getPrecio(),0);
    }

    @Test
    public void getFechaTest(){
        assertEquals(fecha,cli1.getFecha());
        assertEquals(fecha,cli2.getFecha());
        assertEquals(fecha,cli3.getFecha());
    }


    @Test
    public void cambiarTarifaTest(){
        assertEquals(2,cli1.getTarifa().getPrecio(),0);
        cli1.cambiarTarifa(3);
        assertEquals(3,cli1.getTarifa().getPrecio(),0);
        assertEquals(5,cli2.getTarifa().getPrecio(),0);
        cli2.cambiarTarifa(32);
        assertEquals(32,cli2.getTarifa().getPrecio(),0);

    }









}
