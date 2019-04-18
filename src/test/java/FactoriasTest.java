import clases.*;
import org.junit.Test;

import static org.junit.Assert.fail;

public class FactoriasTest {


    FactoriaTarifa fabrica_tarifas=new FactoriaTarifa();
    FactoriaCliente fabrica_clientes=new FactoriaCliente();


    @Test
    public void getEmpresaNuevoTest(){
        boolean es=fabrica_clientes.getEmpresaNuevo("ximo","20",null,"ximo",null,2) instanceof Empresa;
        if(!es) fail();
    }

    @Test
    public void getParticularNuevoTest(){
        boolean es=fabrica_clientes.getParticularNuevo("ximo","gonzalez","20",null,"ximo",null,2) instanceof Particular;
        if(!es) fail();
    }

    @Test
    public void getTarifaBasicaTest(){
        boolean es=fabrica_tarifas.getTarifaBasica(10) instanceof TarifaBasica;
        if(!es) fail();
    }

    @Test
    public void getTarifaHoraTest(){
        boolean es=fabrica_tarifas.getTarifaHora(null,10,null,null) instanceof TarifaHora;
        if(!es) fail();
    }

    @Test
    public void getTarifaDiaTest(){
        boolean es=fabrica_tarifas.getTarifaDia(null,10,null) instanceof TarifaDia;
        if(!es) fail();
    }

}
