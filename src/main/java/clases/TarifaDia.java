package clases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TarifaDia extends TarifaEspecial{

    private DayOfWeek dia;
    float precioEspecial;

    public TarifaDia(Tarifa tarifa,float precioEspecial,DayOfWeek dia){
        super(tarifa,precioEspecial);
        this.dia=dia;
        this.precioEspecial=precioEspecial;
    }


    public float getPrecioTarifa(Llamada llamada){
        if (esAplicable(llamada)){
            if (precioEspecial*llamada.getDuracion()<super.getPrecioTarifa(llamada))
                return precioEspecial*llamada.getDuracion();
        }
        return super.getPrecioTarifa(llamada);
    }


    @Override
    public String toString(){
        return "Se aplica tarifa de dia";
    }

    @Override
    public boolean esAplicable(Llamada llamada){
        if(llamada.getFecha().getDayOfWeek().equals(dia)){
            return true;
        }
        return false;


    }



}
