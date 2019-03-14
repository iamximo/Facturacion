package aplicacion;

    public enum MenuPrincipal {

        CLIENTES("Menu de gestion de clientes"),
        FACTURAS("Menu de gestion de las facturas"),
        LLAMADAS("Menu de gestion de las llamadas"),
        CARGAR("Cargar datos desde un fichero"),
        GUARDAR("Guardar datos en un fichero"),
        SALIR("Finalizar");

        private String descripcion;

        private MenuPrincipal(String descripcion){
            this.descripcion=descripcion;
        }
        public String getDescripcion(){
            return descripcion;
        }
        public static MenuPrincipal getOpcion(int posicion){
            return values()[posicion];
        }
        public static String getMenu(){
            StringBuilder sb = new StringBuilder();

            for(MenuPrincipal opcion : MenuPrincipal.values()){
                sb.append(opcion.ordinal());
                sb.append(".-");
                sb.append(opcion.getDescripcion());
                sb.append('\n');
            }
            return sb.toString();
        }

    }

