package clases;



public class TarifaBasica extends Tarifa{

    public TarifaBasica(float precio){
        super(precio);
    }

    @Override
    public String toString(){
        return "Se aplica tarifa basica";
    }

}
