package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloUsuario;

public class ComandoAccesibilidadDaltonicos extends Comando{


    public ComandoAccesibilidadDaltonicos(ModeloUsuario modeloUsuario) {
        super(modeloUsuario);

    }

    @Override
    public String aplicar() {
        String usuario = controladorUsuario.getUsuarioActual();
        return controladorUsuario.accesibilidadDaltonicos(usuario);
    }

    @Override
    public String getNombre() {
        return "ActivarAccesibilidadDaltonicos";
    }
}
