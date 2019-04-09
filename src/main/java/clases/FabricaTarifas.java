package clases;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface FabricaTarifas {

    TarifaBasica getTarifaBasica(float precio);
    TarifaDia getTarifaDia(Tarifa tarifa, float precioEspecial, DayOfWeek dia);
    TarifaHora getTarifaHora(Tarifa tarifa, float precioEspecial, LocalTime horaIni, LocalTime horaFin);


}
