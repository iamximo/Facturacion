package clases;


import java.io.Serializable;

public class TarifaBasica extends Tarifa implements Serializable {



    public TarifaBasica(float precio){
        super(precio);
    }

    @Override
    public String toString(){
        return "--TarB(Precio:"+precio+")";
    }

}
