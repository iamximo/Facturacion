package excepciones;

public class NoExisteFacturaException extends Exception {

    public NoExisteFacturaException(){
        super("Error: No existe la factura ");
    }
}
