import clases.Direccion;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DireccionTest {

    static Direccion  dir1;
    static Direccion dir2;
    static Direccion dir3;

    @BeforeClass
    public static void generador(){
        dir1=new Direccion(12004,"Castellon de la Plana","Castellon");
        dir2=new Direccion(12118,"Castellon de la Plana","Useras");
        dir3=new Direccion(15700,"La coruña","Santiago de Compostela");

    }


    @Test
    public void getCodigoPostalTest(){
        assertEquals(12004,dir1.getCodigoPostal());
        assertEquals(12118,dir2.getCodigoPostal());
        assertEquals(15700,dir3.getCodigoPostal());
    }

    @Test
    public void getProvinciaTest(){
        assertEquals("Castellon de la Plana",dir1.getProvincia());
        assertEquals("Castellon de la Plana",dir2.getProvincia());
        assertEquals("La coruña",dir3.getProvincia());
    }

    @Test
    public void getPoblacionTest(){
        assertEquals("Castellon",dir1.getPoblacion());
        assertEquals("Useras",dir2.getPoblacion());
        assertEquals("Santiago de Compostela",dir3.getPoblacion());
    }


}
