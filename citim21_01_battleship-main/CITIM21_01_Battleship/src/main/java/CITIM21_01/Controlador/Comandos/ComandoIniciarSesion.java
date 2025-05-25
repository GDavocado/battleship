package CITIM21_01.Controlador.Comandos;

import CITIM21_01.Modelo.ModeloUsuario;
import servidor.ExternalLDAP;

public class ComandoIniciarSesion extends Comando {


    public ComandoIniciarSesion(ModeloUsuario modeloUsuario) {
        super(modeloUsuario);
    }



    @Override
     public String aplicar(){

         String respuesta = "";
         ExternalLDAP external = new ExternalLDAP();
         respuesta = controladorUsuario.login(external.LoginLDAP());
         return respuesta;
    }

    @Override
    public String getNombre(){
        return "IniciarSesion";
    }
}
