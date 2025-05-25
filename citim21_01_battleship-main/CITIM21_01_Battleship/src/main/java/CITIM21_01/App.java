package CITIM21_01;
import CITIM21_01.Controlador.*;
import CITIM21_01.Controlador.Comandos.*;
import CITIM21_01.Modelo.ModeloJugador;
import CITIM21_01.Modelo.ModeloUsuario;
import CITIM21_01.Persistencia.HibernateUtil;
import CITIM21_01.Vista.VistaApp;
import CITIM21_01.Modelo.Error;
import es.upm.etsisi.fis.controller.ControladorPartida;

import java.util.ArrayList;
import java.util.Scanner;




public class App {

    private ModeloUsuario usuario;
    private ModeloJugador jugador;
    private Scanner scanner;
    private ArrayList<Comando> listaComandosOpcionesInicio;
    private ArrayList<Comando> listaComandosOpcionesMenuPrincipal;
    private ControladorUsuario controladorUsuario;
    private ControladorPartida controladorPartida;
    private ControladorJugador controladorJugador;

    private VistaApp vistaApp;

    public App(){
        scanner = new Scanner(System.in);
        usuario = new ModeloUsuario();
        jugador = new ModeloJugador("usuario", scanner);
        controladorPartida = ControladorPartida.getInstance(scanner);
        controladorJugador = ControladorJugador.getInstance(jugador, scanner);

        vistaApp = new VistaApp(scanner);
        //completar esto :D
        listaComandosOpcionesInicio =  new ArrayList<Comando>();
        listaComandosOpcionesMenuPrincipal =  new ArrayList<Comando>();
        //se le pasa IJugador, IPuntuacion, IMovimiento
        listaComandosOpcionesInicio.add(new ComandoIniciarSesion(usuario));
        listaComandosOpcionesMenuPrincipal.add(new ComandoIniciarPartida(usuario, controladorPartida, scanner));
        listaComandosOpcionesMenuPrincipal.add(new ComandoMejoresPuntuaciones(usuario, controladorJugador));
        listaComandosOpcionesMenuPrincipal.add(new ComandoAccesibilidadCiegos(usuario));
        listaComandosOpcionesMenuPrincipal.add(new ComandoAccesibilidadDaltonicos(usuario));
        listaComandosOpcionesMenuPrincipal.add(new ComandoIdiomaIngles(usuario));
        listaComandosOpcionesMenuPrincipal.add(new ComandoEliminarCuenta(usuario));


        //INICIAR PERSISTENCIA EN EL MAIN PREGUNTAR AURORA

        // Cerrar la fábrica de sesiones al finalizar

         controladorUsuario = ControladorUsuario.getInstance(scanner, usuario, listaComandosOpcionesInicio,listaComandosOpcionesMenuPrincipal  );
    }

    public static void main( String[] args ) {
        App app = new App();
        app.start();
        HibernateUtil.shutdown();
    }
    public void start(){

        String nombreComando = "";
        vistaApp.Bienvenido();

        while(true){
            if(usuario.getUsuarioActual().equals("usuario")){

                nombreComando = vistaApp.mostrarComandos(listaComandosOpcionesInicio, scanner);
            }else{


                nombreComando = vistaApp.mostrarComandos(listaComandosOpcionesMenuPrincipal, scanner);
            }
            if(nombreComando == ""){
                vistaApp.printSalida(Error.ENTRADA_VACIA.mensaje);
            }
            Comando comando = controladorUsuario.buscarComando(nombreComando);

            if (comando == null) {
                vistaApp.printSalida(Error.COMANDO_INVALIDO.mensaje);
            } else {

                vistaApp.printSalida(comando.aplicar());


            }
        }

    }

}
