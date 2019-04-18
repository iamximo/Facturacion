package clases;

import java.io.Serializable;

public abstract class TarifaEspecial extends Tarifa implements Serializable {

    protected Tarifa tarifa;


    public TarifaEspecial(Tarifa tarifa, float precioEspecial){
        super(precioEspecial);
        this.tarifa=tarifa;

    }

    public void setTarifaEspecial(Tarifa tar){
        this.tarifa=tar;
    }


    public abstract boolean esAplicable(Llamada llamada);

    @Override
    public String toString() {
        return tarifa.toString();
    }



}
