package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloUsuario;

public class ComandoEliminarCuenta extends Comando{


    public ComandoEliminarCuenta(ModeloUsuario modeloUsuario) {
        super(modeloUsuario);

    }

    @Override
    public String aplicar() {
        String usuario = controladorUsuario.getUsuarioActual();
        return controladorUsuario.eliminarCuenta(usuario);
    }

    @Override
    public String getNombre() {
        return "EliminarCuenta";
    }
}
