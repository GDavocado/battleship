package CITIM21_01.Persistencia;

import es.upm.etsisi.fis.model.IMovimiento;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovimientoDAO {
    public void guardarMovimiento(IMovimiento movimiento){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movimiento);
        transaction.commit();
        session.close();
    }
}
