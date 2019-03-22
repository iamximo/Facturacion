package aplicacion;

import clases.Gestor;

import java.io.*;
import java.util.Scanner;

public class EntradaSalida implements Serializable {

    FileOutputStream fichSalida;
    FileInputStream fichEntrada;

    public void guardarDatos(Gestor gestor){

        Scanner scan= new Scanner(System.in);
        System.out.println("Dime el nombre del fichero para guarar datos;");
        String nombreFich=scan.next();


        try{
            fichSalida=new FileOutputStream(nombreFich);
        }catch (FileNotFoundException e){
            System.out.println("Fichero no encontrado.");
            return;
        }
        try {
            ObjectOutputStream objetoSalida = new ObjectOutputStream(fichSalida);
            objetoSalida.writeObject(gestor);
            objetoSalida.close();
            System.out.println("Datos guardados...");
        }catch (IOException e) { }

    }

    public Gestor cargarDatos(){

        Gestor gestor;
        Scanner scan= new Scanner(System.in);
        System.out.println("Dime el nombre del fichero para cargar datos;");
        String nombreFich=scan.next();

        try{
            fichEntrada=new FileInputStream(nombreFich);
        }catch (FileNotFoundException e){
            System.out.println("\nFichero no encontrado.\n");

        }
        try {

            ObjectInputStream objetoEntrada = new ObjectInputStream(fichEntrada);
            gestor=(Gestor)objetoEntrada.readObject();
            objetoEntrada.close();
            System.out.println("Datos cargados...");
            return gestor;

        }catch (IOException e){}catch (ClassNotFoundException c){}catch(NullPointerException n){}
    return null;
    }


}
