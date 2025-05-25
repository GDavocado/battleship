package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloUsuario;

public class ComandoAccesibilidadCiegos extends Comando{



    public ComandoAccesibilidadCiegos(ModeloUsuario modeloUsuario) {


        super(modeloUsuario);
    }

    @Override
    public String aplicar() {
        String usuario = controladorUsuario.getUsuarioActual();
        return controladorUsuario.accesibilidadCiegos(usuario);
    }

    @Override
    public String getNombre() {
        return "ActivarAccesibilidadCiego";
    }
}
