package clases;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TarifaHora extends TarifaEspecial{

    private LocalTime horaIni;
    private LocalTime horaFin;


    public TarifaHora(Tarifa tarifa,float precioEspecial,LocalTime horaIni,LocalTime horaFin){
        super(tarifa,precioEspecial);
        this.horaIni=horaIni;
        this.horaFin=horaFin;


    }

    @Override
    public String toString(){
        return "Esta tarifa es HORA";
    }

    public float getPrecioTarifa(Llamada llamada){
        if (esAplicable(llamada)){
            if (llamada.getDuracion()*precio<tarifa.getPrecioTarifa(llamada)) return llamada.getDuracion()*precio;
        }
        return tarifa.getPrecioTarifa(llamada);
    }


    @Override
    public boolean esAplicable(Llamada llamada){
        if((llamada.getFecha().toLocalTime().isAfter(horaIni) || llamada.getFecha().toLocalTime().equals(horaIni))&&(llamada.getFecha().plusMinutes((long)llamada.getDuracion()).toLocalTime().isBefore(horaFin) ||llamada.getFecha().plusMinutes((long)llamada.getDuracion()).toLocalTime().equals(horaFin) )){
            return true;
        }
        return false;
    }
    public Tarifa getTarifaEncapsulada(){
        return tarifa;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}
