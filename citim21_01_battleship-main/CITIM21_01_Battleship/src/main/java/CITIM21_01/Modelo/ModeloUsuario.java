package CITIM21_01.Modelo;

import CITIM21_01.Persistencia.UsuarioDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class ModeloUsuario {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Id
    @Column(name = "usuario", unique = true, nullable = false)
    private String usuarioActual = "usuario";

    @Column(name = "ciego")
    private boolean ciego = false;
    @Column(name = "daltonico")
    private boolean daltonico = false;
    @Column(name = "ingles")
    private boolean ingles = false;

    public ModeloUsuario(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public ModeloUsuario() {}

    public String login(String codigoUsuario){
        if(usuarioDAO.obtenerJugador(codigoUsuario)==null){
            ModeloUsuario usuario = new ModeloUsuario(codigoUsuario);
            usuarioDAO.guardarUsuario(usuario);
            usuarioActual=codigoUsuario;
            return "\n\n\n\nUsuario registrado correctamente\n\n";
        }else{
            usuarioActual=codigoUsuario;
            return "\n\n\n\nSe ha iniciado sesión correctamente.\n\n";
        }
    }

    public String eliminarCuenta(String codigoUsuario){
        ModeloUsuario usuario = usuarioDAO.obtenerJugador(codigoUsuario);
        usuarioDAO.borrarCuenta(usuario);
        return "\n\n\n\nSe ha eliminado la cuenta con éxito\n\n";
    }

    public String getUsuarioActual(){
        return this.usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean isCiego() {
        return ciego;
    }

    public void setCiego(boolean ciego) {
        this.ciego = ciego;
    }

    public boolean isDaltonico() {
        return daltonico;
    }

    public void setDaltonico(boolean daltonico) {
        this.daltonico = daltonico;
    }

    public boolean isIngles() {
        return ingles;
    }

    public void setIngles(boolean ingles) {
        this.ingles = ingles;
    }

    public String cambiarIdiomaIngles(String codigoUsuario){
        return usuarioDAO.cambiarIngles(codigoUsuario);
    }

    public String accesibilidadCiegos(String codigoUsuario){
        return usuarioDAO.cambiarCiego(codigoUsuario);
    }

    public String accesibilidadDaltonicos(String codigoUsuario){
        return usuarioDAO.cambiarDaltonico(codigoUsuario);
    }


}
