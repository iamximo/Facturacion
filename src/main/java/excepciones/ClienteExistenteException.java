package excepciones;

public class ClienteExistenteException extends Exception {

    public ClienteExistenteException(){
        super("Error: Ya existe un cliente con ese NIF");
    }
}
