package aplicacion;

public enum MenuLlamadas{

    ALTA_LLAMADA("Dar de alta una llamada"),
    LLAMADAS_CLIENTE("Consultar las llamadas de un cliente"),
    LLAMADAS_INTERVALO("Consultar el listado de llamadas de un cliente en un intervalo"),
    PRINCIPAL("Volver al menu principal");

    private String descripcion;

    private MenuLlamadas(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public static MenuLlamadas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();

        for (MenuLlamadas opcion : MenuLlamadas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".-");
            sb.append(opcion.getDescripcion());
            sb.append('\n');
        }
        return sb.toString();
    }

}
