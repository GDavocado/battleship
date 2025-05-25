package CITIM21_01.Persistencia;

import CITIM21_01.Modelo.ModeloUsuario;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuarioDAO {

    public void guardarUsuario(ModeloUsuario usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
    }

    public void borrarCuenta(ModeloUsuario usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(usuario);
        transaction.commit();
        session.close();
    }

    public ModeloUsuario obtenerJugador(String codigoUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ModeloUsuario.class, codigoUsuario);
        }
    }

    public String cambiarIngles(String codigoUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ModeloUsuario usuario = session.get(ModeloUsuario.class, codigoUsuario);
        usuario.setIngles(true);
        session.update(usuario);
        transaction.commit();
        session.close();
        return "Se ha cambiado el idioma a inglés.";
    }

    public String cambiarCiego(String codigoUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ModeloUsuario usuario = session.get(ModeloUsuario.class, codigoUsuario);
        usuario.setCiego(true);
        session.update(usuario);
        transaction.commit();
        session.close();
        return "Se ha activado el modo para ciegos.";
    }

    public String cambiarDaltonico(String codigoUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ModeloUsuario usuario = session.get(ModeloUsuario.class, codigoUsuario);
        usuario.setDaltonico(true);
        session.update(usuario);
        transaction.commit();
        session.close();
        return "Se ha activado el modo para daltónicos.";
    }

}
