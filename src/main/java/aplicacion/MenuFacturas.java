package aplicacion;

public enum MenuFacturas {

    EMITIR_FACTURA("Emitir facutura"),
    COLSULTAR_FACTURA("Consultar datos de una factura"),
    FACTURAS_CLIENTE("Consultar todas las facturas de un cliente"),
    PRINCIPAL("Volver al menu principal");

    private String descripcion;

    private MenuFacturas(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static MenuFacturas getOpcion(int posicion) {
        return values()[posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();

        for (MenuFacturas opcion : MenuFacturas.values()) {
            sb.append(opcion.ordinal());
            sb.append(".-");
            sb.append(opcion.getDescripcion());
            sb.append('\n');
        }
        return sb.toString();
    }
}
