package clases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TarifaDia extends TarifaEspecial{

    private DayOfWeek dia;
    private Tarifa tarifa;



    public TarifaDia(Tarifa tarifa,float precioEspecial,DayOfWeek dia){
        super(tarifa,precioEspecial);
        this.dia=dia;
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
