package CITIM21_01.Controlador;

import CITIM21_01.Modelo.ModeloJugador;
import CITIM21_01.Modelo.ModeloPuntuacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import CITIM21_01.Vista.VistaApp;
import CITIM21_01.Modelo.Error;
import es.upm.etsisi.fis.model.IPuntuacion;

import java.util.Scanner;

public class ControladorJugador {
    private ModeloJugador modeloJugador;
    private static ControladorJugador instance;

    private VistaApp vistaApp;

    private ControladorJugador(ModeloJugador modeloJugador1, Scanner scanner) {
        this.modeloJugador =  modeloJugador1;
        vistaApp = new VistaApp(scanner);
    }

    public static ControladorJugador getInstance(ModeloJugador modeloJugador, Scanner scanner){
        if(instance == null){
            instance = new ControladorJugador(modeloJugador, scanner);
        }
         return instance;
    }

    public ArrayList<IPuntuacion> mejoresPuntuaciones() {

        ArrayList<IPuntuacion> lista = modeloJugador.getPuntuaciones();
        if (lista == null || lista.isEmpty()) {
            vistaApp.printSalida(Error.SIN_PUNTUACIONES.mensaje);
            return new ArrayList<>();
        }

        lista.sort((o1, o2) -> Long.compare(o2.getPuntos(), o1.getPuntos()));

        int tamañoResultado = Math.min(10, lista.size());

        ArrayList<IPuntuacion> resultado = new ArrayList<>();
        for (int i = 0; i < tamañoResultado; i++) {
            resultado.add(lista.get(i).clonePuntuacion());
        }

        return resultado;
    }

}