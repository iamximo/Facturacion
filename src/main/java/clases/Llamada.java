package clases;

import java.time.LocalDateTime;

public class Llamada implements Fecha{

    private String numDestino;
    private LocalDateTime fechaHora;
    private float duracion; // En  minutos

    public Llamada(String numDestino, LocalDateTime fechaHora, float duracion){

        this.numDestino=numDestino;
        this.fechaHora=fechaHora;
        this.duracion=duracion;
    }

    public String getNumDestino() {
        return numDestino;
    }

    public LocalDateTime getFecha() {
        return fechaHora;
    }

    public float getDuracion() {
        return duracion;
    }

    public String toString(){
        return "\nNUMERO DESTINO: "+this.numDestino+"\nFECHA: "+this.fechaHora+"\nDURACION: "+this.duracion;
    }


}
