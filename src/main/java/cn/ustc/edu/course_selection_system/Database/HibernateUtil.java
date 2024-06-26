package cn.ustc.edu.course_selection_system.Database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory = null;

    private HibernateUtil() {
    }

    /**
     * Get the singleton session factory, using double-checked locking to ensure thread safety
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        synchronized (HibernateUtil.class) {
            if (null == sessionFactory) {
                setUp();
            }
        }
        return sessionFactory;
    }

    /**
     * Set up the session factory
     */
    private static void setUp() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
//        try {
//            sessionFactory = new MetadataSources(registry)
//                    .addAnnotatedClasses(StudentEntity.class)
//                    .buildMetadata()
//                    .buildSessionFactory();
//        }
//        catch (HibernateException e) {
//            // The registry would be destroyed by the SessionFactory, but we
//            // had trouble building the SessionFactory so destroy it manually.
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
