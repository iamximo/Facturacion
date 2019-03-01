
import java.time.LocalDateTime;
import clases.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LlamadaTest {

    LocalDateTime fecha = LocalDateTime.of(1999,11,06,10,00);
    LocalDateTime fecha2 = LocalDateTime.of(1999,11,9,1,00);

    Llamada llam1 = new Llamada("603548721",fecha,80);
    Llamada llam2 = new Llamada("675643254",fecha2,1);

    @Test
    public void getNumDestinoTest(){
        assertEquals("603548721",llam1.getNumDestino());
        assertEquals("675643254",llam2.getNumDestino());
    }

    @Test
    public void getFechaTest(){
        assertEquals(fecha,llam1.getFecha());
        assertEquals(fecha2,llam2.getFecha());
    }

    @Test
    public void getDuracionTest(){
        assertEquals(80,llam1.getDuracion(),0);
        assertEquals(1,llam2.getDuracion(),0);
    }



}
