package CITIM21_01.Modelo;

import CITIM21_01.Persistencia.MovimientoDAO;
import CITIM21_01.Persistencia.PuntuacionDAO;
import CITIM21_01.Vista.VistaJugador;
import es.upm.etsisi.fis.model.IJugador;
import es.upm.etsisi.fis.model.IMovimiento;
import es.upm.etsisi.fis.model.IPuntuacion;
import es.upm.etsisi.fis.model.TBarcoAccionComplementaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ModeloJugador implements IJugador {
    private String nombre;

    private List<IMovimiento> movimientos;
    private List<IPuntuacion> puntuaciones;

    private VistaJugador vistaJugador;

    private MovimientoDAO movimientoDAO = new MovimientoDAO();
    private PuntuacionDAO puntuacionDAO = new PuntuacionDAO();

    public ModeloJugador(String nombre, Scanner scanner) {

        this.vistaJugador = new VistaJugador(scanner);
        this.nombre = nombre;
        this.movimientos = new ArrayList<>();
        this.puntuaciones = new ArrayList<>();
    }

    public boolean aceptarAccionComplementaria(TBarcoAccionComplementaria tipo, int cantidadDisponible) {
        if (cantidadDisponible <= 0) return false;

        String respuesta = vistaJugador.usarHabilidad(cantidadDisponible, tipo.name());
        return respuesta.equals("S");

    }
    
    public int[] realizaTurno(char[][] tablero) {

        int fila = -1;
        int columna = -1;

        while (true) {
            try {
                String[] input = vistaJugador.pedirCasilla();
                fila = Integer.parseInt(input[0]);
                columna = Integer.parseInt(input[1]);

                if (fila >= 0 && fila < tablero.length &&
                        columna >= 0 && columna < tablero[0].length) {
                    break;
                } else {
                    vistaJugador.printSalida(Error.COORDENADAS_INVALIDAS.mensaje);
                }
            } catch (Exception e) {
                vistaJugador.printSalida(Error.FORMATO_INCORRECTO.mensaje);
            }
        }
        return new int[]{fila, columna};
    }

    public void addMovimiento(IMovimiento movIn) {
        IMovimiento cloned = movIn.cloneMovimiento();
        movimientos.add(cloned);
        movimientoDAO.guardarMovimiento(movIn);
    }

    public String getNombre() {
        return nombre;
    }

    public void addPuntuacion(IPuntuacion punIn) {
        IPuntuacion cloned = punIn.clonePuntuacion();
        puntuaciones.add(cloned);
        puntuacionDAO.guardarPuntuacion(cloned);
    }

    public ArrayList<IMovimiento> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    public ArrayList<IPuntuacion> getPuntuaciones() {
        return new ArrayList<>(puntuaciones);
    }

    
}