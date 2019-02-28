import java.time.LocalDateTime;
import clases.*;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class ParticularTest {

    Particular part1= new Particular(null,"Martinez",null,null,null,null,2);
    Particular part2= new Particular(null,"Beltran Gonzalez",null,null,null,null,2);
    @Test
    public void getApellidos(){
        assertEquals("Martinez",part1.getApellidos());
        assertEquals("Beltran Gonzalez",part2.getApellidos());

    }



}
