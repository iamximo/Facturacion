package clases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TarifaDia extends TarifaEspecial{

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
        return "Esta tarifa es DIA";
    }

    @Override
    public boolean esAplicable(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals(dia)){
            return true;
        }
        return false;


    }
    public Tarifa getTarifaEncapsulada(){
        return tarifa;
    }



}
