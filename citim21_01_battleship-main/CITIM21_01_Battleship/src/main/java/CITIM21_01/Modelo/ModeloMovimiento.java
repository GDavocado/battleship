package CITIM21_01.Modelo;

import es.upm.etsisi.fis.model.IMovimiento;

import javax.persistence.*;

//falta probar de aqui para abajo :(
@Entity
@Table(name="movimientos")
public class ModeloMovimiento implements IMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private int id;
    @Column(name="partidaId", nullable=false)
    private long partidaId;
    @Column(name="fila")
    private int fila;
    @Column(name="columna")
    private int columna;
    @Column(name="time")
    private long tiempo;
    
    public IMovimiento cloneMovimiento() {
        ModeloMovimiento clon = new ModeloMovimiento();
        clon.partidaId = this.partidaId;
        return clon;
    }

    @Override
    public void setPartidaId(Long aLong) {

    }

    public void setPartidaId(long partidaId) {
        this.partidaId = partidaId;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public void setTime(long tiempo) {
        this.tiempo = tiempo;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public long getPartidaId() {
        return partidaId;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public long getTime() {
        return tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
