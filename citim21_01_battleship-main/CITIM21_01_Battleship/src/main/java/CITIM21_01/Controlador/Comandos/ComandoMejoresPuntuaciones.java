package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Controlador.ControladorJugador;
import CITIM21_01.Modelo.ModeloUsuario;
import es.upm.etsisi.fis.model.IPuntuacion;

import java.util.ArrayList;

public class ComandoMejoresPuntuaciones extends Comando{
    private ControladorJugador controladorJugador;

    public ComandoMejoresPuntuaciones(ModeloUsuario modeloUsuario, ControladorJugador controladorJugador) {
        super(modeloUsuario);
        this.controladorJugador = controladorJugador;
    }

    @Override
    public String aplicar() {

        StringBuffer buffer = new StringBuffer();

        ArrayList<IPuntuacion> puntuaciones = controladorJugador.mejoresPuntuaciones();

        buffer.append("Mejores Puntuaciones:\n");

        for(IPuntuacion pun: puntuaciones){

            buffer.append("-  "+pun.getPuntos()+"\n");

        }

        return buffer.toString();
    }

    @Override
    public String getNombre() {
        return "10MejoresPuntuaciones";
    }
}
