package aplicacion;

public enum MenuCliente{

    ALTA_NUEVO_CLIENTE("Dar de alta un nuevo cliente"),
    ALTA_NUEVO_PARTICULAR("Dar de alta un nuevo cliente particular"),
    BORRAR_CLIENTE("Borrar un cliente"),
    CAMBIO_TARIFA("Cambiar la tarifa de un cliente"),
    DATOS_CLIENTE("Consultar los datos de un cliente"),
    LISTADO_CLIENTES("Consultar el listado de todos los clientes"),
    AUTOMATICO("Dar de alta clientes de forma automatica"),
    PRINCIPAL("Volver al menu principal");

    private String descripcion;

    private MenuCliente(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public static MenuCliente getOpcion(int posicion){
        return values()[posicion];
    }
    public static String getMenu(){
        StringBuilder sb = new StringBuilder();

        for(MenuCliente opcion : MenuCliente.values()){
            sb.append(opcion.ordinal());
            sb.append(".-");
            sb.append(opcion.getDescripcion());
            sb.append('\n');
        }
        return sb.toString();
    }


}
