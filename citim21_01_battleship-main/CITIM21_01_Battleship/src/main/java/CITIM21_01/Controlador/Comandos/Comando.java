package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloUsuario;

public abstract class Comando {

    protected final ModeloUsuario controladorUsuario;

    public Comando(ModeloUsuario controladorUsuario){
        this.controladorUsuario = controladorUsuario;

    }




    public abstract String aplicar();
    public abstract String getNombre();
}
