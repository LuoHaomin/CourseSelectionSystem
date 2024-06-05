package cn.ustc.edu.course_selection_system.Database;

import javafx.event.Event;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.usertype.UserType;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory = null;
//    private static final Configuration configuration = new Configuration().configure();

    private HibernateUtil() {
    }

    /**
     * Get the singleton session factory, using double-checked locking to ensure thread safety
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    setUp();
                }
            }
        }
        return sessionFactory;
    }

    private static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Event.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (HibernateException e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
