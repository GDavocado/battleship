package CITIM21_01.Modelo;


public enum Error {
    ENTRADA_VACIA("No se ha escrito nada por pantalla"),

    COORDENADAS_INVALIDAS("Coordenadas inválidas. Intente nuevamente:"),

    FORMATO_INCORRECTO("Formato incorrecto. Use formato numerico -> fila columna"),
    SIN_PUNTUACIONES("No se han jugado partidas"),
    COMANDO_INVALIDO("El comando no existe");

    public final String mensaje;

    Error(String mensaje) {
        this.mensaje = mensaje;
    }
}
