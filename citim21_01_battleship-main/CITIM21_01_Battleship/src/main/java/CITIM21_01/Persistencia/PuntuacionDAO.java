package CITIM21_01.Persistencia;

import es.upm.etsisi.fis.model.IPuntuacion;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PuntuacionDAO {
    public void guardarPuntuacion(IPuntuacion puntuacion){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(puntuacion);
        transaction.commit();
        session.close();
    }
}
