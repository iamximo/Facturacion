package clases;

public abstract class TarifaEspecial extends Tarifa {

    private Tarifa tarifa;

    public TarifaEspecial(Tarifa tarifa, float precioEspecial){
        super(precioEspecial);
        this.tarifa=tarifa;

    }

    @Override
    public float getPrecio(Llamada llamada){
        float minPrecioAplicable=super.getPrecio();

        if(tarifa.getPrecio(llamada)<minPrecioAplicable){
                minPrecioAplicable=tarifa.getPrecio(llamada);
        }








    }

    public abstract boolean esAplicable(Llamada llamada);

    @Override
    public String toString() {
        return tarifa.toString();
    }
}
