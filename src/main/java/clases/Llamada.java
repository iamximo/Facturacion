package clases;

import java.time.LocalDateTime;

public class Llamada implements Fecha{

    private String numDestino;
    private LocalDateTime fechaHora;
    private float duracion;

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
}
