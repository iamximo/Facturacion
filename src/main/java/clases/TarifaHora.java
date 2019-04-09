package clases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TarifaHora extends TarifaEspecial{

    private LocalTime horaIni;
    private LocalTime horaFin;
    float precioEspecial;

    public TarifaHora(Tarifa tarifa,float precioEspecial,LocalTime horaIni,LocalTime horaFin){
        super(tarifa,precioEspecial);
        this.horaIni=horaIni;
        this.horaFin=horaFin;
        this.precioEspecial=precioEspecial;

    }

    @Override
    public String toString(){
        return "Se aplica tarifa de horas";
    }

    public float getPrecioTarifa(Llamada llamada){
        if (esAplicable(llamada)){
            if (llamada.getDuracion()*precioEspecial<super.getPrecioTarifa(llamada)) return llamada.getDuracion()*precioEspecial;
        }
        return super.getPrecioTarifa(llamada);
    }


    @Override
    public boolean esAplicable(Llamada llamada){
        if(llamada.getFecha().toLocalTime().isAfter(horaIni) && llamada.getFecha().toLocalTime().isBefore(horaFin)){
            return true;
        }
        return false;
    }



}
