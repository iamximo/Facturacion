
import clases.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParticularTest {
    FactoriaCliente fabrica=new FactoriaCliente();

    Particular part1= fabrica.getParticularNuevo(null,"Martinez",null,null,null,null,2);
    Particular part2= fabrica.getParticularNuevo(null,"Beltran Gonzalez",null,null,null,null,2);
    @Test
    public void getApellidos(){
        assertEquals("Martinez",part1.getApellidos());
        assertEquals("Beltran Gonzalez",part2.getApellidos());

    }



}
