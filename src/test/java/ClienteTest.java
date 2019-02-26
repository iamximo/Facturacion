import clases.Cliente;
import clases.Direccion;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    static Cliente  cli1;
    static Cliente cli2;
    static Cliente cli3;

    @BeforeClass
    public static void generador(){
        Direccion dir1=new Direccion(12004,"Castellon de la Plana","Castellon");
        Direccion dir2=new Direccion(12118,"Castellon de la Plana","Useras");
        Direccion dir3=new Direccion(15700,"La coruña","Santiago de Compostela");

        LocalDateTime fecha1=LocalDateTime.of(1999,11,6,9,0);
        LocalDateTime fecha2=LocalDateTime.of(2000,12,2,7,0);
        LocalDateTime fecha3=LocalDateTime.of(2018,1,2,6,22);


        cli1=new Cliente("Ximo","20914826Y",dir1,"ximoxd@gmail.com",fecha1,5);
        cli2=new Cliente("Juan","18974742U",dir1,"juan_su@gmail.com",fecha2,1);
        cli3=new Cliente("Laura","86532426S",dir1,"lauritta@yahoo.com",fecha3,2);

    }


    @Test
    public void cambiarTarifaTest(){
        assertEquals(5,cli1.getTarifa().getPrecio(),0);
        cli1.cambiarTarifa(6);
        assertEquals(6,cli1.getTarifa().getPrecio(),0);
    }


     //Faltan tests de metodos


}
