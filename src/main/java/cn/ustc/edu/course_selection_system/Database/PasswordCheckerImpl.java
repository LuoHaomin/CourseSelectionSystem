package cn.ustc.edu.course_selection_system.Database;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PasswordCheckerImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    //TODO:
    public boolean isPasswordCorrect(String id, String password) {
        List<Boolean> result = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<String> password1 = session.createQuery("select password from " +
                            "StudentEntity where id = :id", String.class)
                    .setParameter("id", id)
                    .getResultList();
            if (password1.size() != 0)
                result.add(password1.get(0).equals(password));
            List<String> password2 = session.createQuery("select password from " +
                            "TeacherEntity where id = :id", String.class)
                    .setParameter("id", id)
                    .getResultList();
            if (password2.size() != 0)
                result.add(password2.get(0).equals(password));
            List<String> password3 = session.createQuery("select password from " +
                            "AdminEntity where id = :id", String.class)
                    .setParameter("id", id)
                    .getResultList();
            if (password3.size() != 0)
                result.add(password3.get(0).equals(password));
        });
        if (result.get(0))
            return true;
        else
            return false;
    }
}
