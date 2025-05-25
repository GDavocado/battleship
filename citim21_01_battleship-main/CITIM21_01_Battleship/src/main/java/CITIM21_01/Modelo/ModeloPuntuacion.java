package CITIM21_01.Modelo;

import es.upm.etsisi.fis.model.IPuntuacion;

import javax.persistence.*;

//falta probar de aqui para abajo :(
@Entity
@Table(name = "puntuaciones")
public class ModeloPuntuacion implements IPuntuacion {
    @Column(name="puntos")
    private long puntos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="partidaId", unique=true, nullable=false)
    private long partidaId;
    
    public long getPuntos() {
        return puntos;
    }
    
    public IPuntuacion clonePuntuacion() {
        ModeloPuntuacion clon = new ModeloPuntuacion();
        clon.puntos = this.puntos;          
        clon.partidaId = this.partidaId;    
        return clon;
    }
    
    public void setPuntuacion(long puntos) {
        this.puntos = puntos;
    }

    public void setPuntos(long puntos) {
        this.puntos = puntos;
    }

    public long getPartidaId() {
        return partidaId;
    }

    @Override
    public void setPartidaId(Long aLong) {

        this.partidaId = aLong;

    }



}
