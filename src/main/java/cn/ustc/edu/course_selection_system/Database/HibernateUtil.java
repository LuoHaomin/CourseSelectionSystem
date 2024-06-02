package cn.ustc.edu.course_selection_system.Database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory;
    private static final Configuration configuration = new Configuration().configure("/src/main/resources/hibernate.cfg.xml");

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
                    return configuration.buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }
}
