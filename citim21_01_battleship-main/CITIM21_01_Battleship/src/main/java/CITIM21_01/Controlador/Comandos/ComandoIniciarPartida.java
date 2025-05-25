package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloMovimiento;
import CITIM21_01.Modelo.ModeloPuntuacion;
import CITIM21_01.Modelo.ModeloUsuario;
import CITIM21_01.Modelo.ModeloJugador;
import es.upm.etsisi.fis.controller.ControladorPartida;
import java.util.Scanner;

public class ComandoIniciarPartida extends Comando{

    ControladorPartida controladorPartida;
    ModeloJugador jugador;
    ModeloPuntuacion puntuacion;
    ModeloMovimiento movimiento;


    //constructor
    public ComandoIniciarPartida(ModeloUsuario modeloUsuario,
                                 ControladorPartida controladorPartida, Scanner scanner){
        super(modeloUsuario); //este no se usa pero bueno

        this.controladorPartida = controladorPartida;
       this.jugador = new ModeloJugador(modeloUsuario.getUsuarioActual(), scanner);
       this.puntuacion = new ModeloPuntuacion();
       this.movimiento = new ModeloMovimiento();
    }

    @Override
    public String aplicar() {

        //se le pasa IJugador, IPuntuacion, IMovimiento


        controladorPartida.crearPartida(jugador, puntuacion, movimiento);

        return "PARTIDA FINALIZADA :D\nGRACIAS POR JUGAR\n";
    }

    @Override
    public String getNombre() {
        return "IniciarPartida";
    }
}
