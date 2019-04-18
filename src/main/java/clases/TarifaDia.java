package clases;

import java.io.Serializable;
import java.time.DayOfWeek;

public class TarifaDia extends TarifaEspecial implements Serializable {



    private DayOfWeek dia;


    public TarifaDia(Tarifa tarifa,float precioEspecial,DayOfWeek dia){
        super(tarifa,precioEspecial);
        this.dia=dia;
    }


    public float getPrecioTarifa(Llamada llamada){
        if (esAplicable(llamada)){
            if (precio*llamada.getDuracion() < tarifa.getPrecioTarifa(llamada))
                return precio*llamada.getDuracion();
        }
        return tarifa.getPrecioTarifa(llamada);
    }


    @Override
    public String toString(){
        return "--TarD(DIA:"+dia +" Precio:"+precio+")"+tarifa.toString();
    }

    @Override
    public boolean esAplicable(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals(dia)){
            return true;
        }
        return false;


    }



}
