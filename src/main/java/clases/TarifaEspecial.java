package clases;

public abstract class TarifaEspecial extends Tarifa {

    protected Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precioEspecial){
        super(precioEspecial);
        this.tarifa=tarifa;

    }


    public abstract boolean esAplicable(Llamada llamada);

    @Override
    public String toString() {
        return tarifa.toString();
    }
}
