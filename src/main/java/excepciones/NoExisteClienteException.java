package excepciones;

public class NoExisteClienteException extends Exception {

    public NoExisteClienteException(){
        super("Error: No existe el cliente");
    }
}
