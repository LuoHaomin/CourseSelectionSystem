package cn.ustc.edu.course_selection_system.tests;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static java.time.LocalDateTime.now;

/**
 * Illustrates the use of Hibernate native APIs, including the use
 * of org.hibernate.boot for configuration and bootstrap.
 * Configuration properties are sourced from hibernate.properties.
 *
 * @author Steve Ebersole
 */
public class HibernateIllustrationTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Event.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterAll
    public static void tearDown() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    @Test
    public void testBasicUsage() {
        // create a couple of events...
        sessionFactory.inTransaction(session -> {
            session.persist(new Event("Our very first event!", now()));
            session.persist(new Event("A follow up event", now()));
        });

        // now lets pull events from the database and list them
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Event", Event.class).getResultList()
                    .forEach(event -> out.println("Event (" + event.getDate() + ") : " + event.getTitle()));
        });
    }
}

