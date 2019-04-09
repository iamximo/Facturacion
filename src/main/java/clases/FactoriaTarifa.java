package clases;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class FactoriaTarifa implements  FabricaTarifas {

    @Override
    public TarifaBasica getTarifaBasica(float precio) {
        return new TarifaBasica(precio);
    }

    @Override
    public TarifaDia getTarifaDia(Tarifa tarifa, float precioEspecial, DayOfWeek dia) {
        return new TarifaDia(tarifa,precioEspecial,dia);
    }

    @Override
    public TarifaHora getTarifaHora(Tarifa tarifa, float precioEspecial, LocalTime horaIni, LocalTime horaFin) {
        return new TarifaHora(tarifa,precioEspecial,horaIni,horaFin);
    }
}
