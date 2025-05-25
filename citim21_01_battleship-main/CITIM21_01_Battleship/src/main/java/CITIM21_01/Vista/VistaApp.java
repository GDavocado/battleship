package CITIM21_01.Vista;

import java.util.ArrayList;
import java.util.Scanner;
import CITIM21_01.Controlador.Comandos.*;

//menú principal y opciones
public class VistaApp extends Vista{


    public VistaApp(Scanner scanner) {
        super(scanner);
    }
    public void Bienvenido(){
        StringBuffer salida1 = new StringBuffer(), salida2 = new StringBuffer();
        String respuesta = "";
        salida1.append("   ---------------------------------\n");
        salida1.append("   BIENVENIDO AL JUEGO DE BATTLESHIP\n");
        salida1.append("   ---------------------------------\n\n");
        printSalida(salida1.toString());
    }
    /*public String registro(){




        ExternalLDAP external = new ExternalLDAP();
        respuesta = external.LoginLDAP();

        return respuesta;

    }*/

    public String mostrarComandos(ArrayList<Comando> comandos, Scanner scanner) {
        StringBuffer string = new StringBuffer();
        printSalida("\n\n\nComandos disponibles:\n");
        for(Comando comando : comandos){
            string.append("   - "+comando.getNombre()+"\n");
        }

        printSalida(string.toString());
        return scanner.nextLine();
    }
    


}
