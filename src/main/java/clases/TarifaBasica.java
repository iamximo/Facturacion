package clases;



public class TarifaBasica extends Tarifa{

    public TarifaBasica(float precio){
        super(precio);
    }

    @Override
    public String toString(){
        return "Esta tarifa es BASICA";
    }

    @Override
    public Tarifa getTarifaEncapsulada() {
        return null;
    }
}
