package CITIM21_01.Vista;

import java.util.Scanner;

//usar habilidades y pedir casillas
public class VistaJugador extends Vista{
    public VistaJugador(Scanner scanner){
        super(scanner);
    }
    public String usarHabilidad(int cantidadDisponible, String nombre){
        System.out.println("¿Desea usar " + nombre + "? (" + cantidadDisponible + " disponibles) (S/N)");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        return respuesta;
    }
    public String[] pedirCasilla(){
        System.out.println("Ingrese coordenadas de ataque (fila columna):");
        String[] input = scanner.nextLine().split(" ");
        return input;
    }
}
