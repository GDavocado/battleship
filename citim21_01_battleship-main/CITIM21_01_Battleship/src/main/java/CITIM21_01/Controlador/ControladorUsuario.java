package CITIM21_01.Controlador;
import CITIM21_01.Controlador.Comandos.*;
import CITIM21_01.Modelo.ModeloUsuario;
import CITIM21_01.Vista.VistaApp;


import java.util.ArrayList;
import java.util.Scanner;


public class ControladorUsuario {
    private Scanner scanner;
    private static ControladorUsuario instance;
    private ArrayList<Comando>  listaComandosOpcionesInicio;
    private ArrayList<Comando> listaComandosOpcionesMenuPrincipal;
    private ModeloUsuario usuario;


    private ControladorUsuario(Scanner scanner, ModeloUsuario inputUsuario, ArrayList<Comando> comandosInicio, ArrayList<Comando> comandoMenuPrincipal) {

        this.scanner = scanner;
        this.usuario = inputUsuario;

        this.listaComandosOpcionesInicio =  comandosInicio;
        this.listaComandosOpcionesMenuPrincipal =  comandoMenuPrincipal;

    }

    public static ControladorUsuario getInstance(Scanner scanner, ModeloUsuario inputUsuario, ArrayList<Comando> comandosInicio, ArrayList<Comando> comandoMenuPrincipal){
        if (instance == null){
            instance = new ControladorUsuario(scanner, inputUsuario, comandosInicio, comandoMenuPrincipal);
        }
        return instance;
    }


        

    
public Comando buscarComando(String nombreComando) {
        if (usuario.getUsuarioActual().equals("usuario")) {// comandos sin hacer login
            return listaComandosOpcionesInicio.stream()
                    .filter(comando -> comando.getNombre().equalsIgnoreCase(nombreComando))
                    .findFirst()
                    .orElse(null);
        } else { //comandos hecho el login
            return listaComandosOpcionesMenuPrincipal.stream()
                    .filter(comando -> comando.getNombre().equalsIgnoreCase(nombreComando))
                    .findFirst()
                    .orElse(null);
        }

    }

}
