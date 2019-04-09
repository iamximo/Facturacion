
import clases.*;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;


public class FacturaTest {

    LocalDateTime fecha = LocalDateTime.of(1999,11,06,10,00);
    LocalDateTime fecha2 = LocalDateTime.of(2000,11,06,10,00);
    Tarifa tar=new TarifaBasica(2);
    Factura fact=new Factura("1",tar,fecha,fecha2);

    @Test
    public void getCodigoTest(){
        assertEquals("1",fact.getCodigo());
    }

    @Test
    public void getTarifaTest(){
        assertEquals(tar,fact.getTarifa());
    }

    @Test
    public void getFechaTest(){
        assertEquals(null,fact.getFecha());
    }

    @Test
    public void setFechaEmisionTest(){
        fact.setFechaEmision(fecha);
        assertEquals(fecha,fact.getFecha());
    }

    @Test
    public void getImporteTest(){
        assertEquals(0,fact.getImporte(),0);
    }


    @Test
    public void setImporteTest(){
        assertEquals(0,fact.getImporte(),0);
        fact.setImporte(2);
        assertEquals(2,fact.getImporte(),0);
    }

    @Test
    public void getInicioFacturacionTest(){
        assertEquals(fecha,fact.getInicioFacturacion());
    }

    @Test
    public void getFinFacturacionTest(){
        assertEquals(fecha2,fact.getFinFacturacion());
    }


}
