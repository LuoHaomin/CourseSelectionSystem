package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.AdminEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AdminImpl {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Add an admin to the database
     * @param password the password of the admin
     */
    public void addAdmin(String password){
        AdminEntity admin = new AdminEntity();
        admin.setPassword(password);
        sessionFactory.inTransaction(session -> {
            session.persist(admin);
        });
    }

    /**
     * Add an admin to the database
     * @param id the id of the admin
     * @return the id of the admin
     */
    public AdminEntity getAdmin(int id){
        List<AdminEntity> adminList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<AdminEntity> _adminList = session.createQuery("from AdminEntity where id = :id",
                            AdminEntity.class)
                    .setParameter("id", id)
                    .getResultList();
            adminList.addAll(_adminList);
        });
        return adminList.get(0);
    }

}
