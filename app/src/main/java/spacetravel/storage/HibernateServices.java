package spacetravel.storage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spacetravel.client.Client;
import spacetravel.planet.Planet;
import spacetravel.ticket.Ticket;

public class HibernateServices {
    private static final HibernateServices INSTANCE;
    private final SessionFactory sessionFactory;


    static {
        INSTANCE = new HibernateServices();
    }

    public HibernateServices() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateServices getINSTANCE() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
