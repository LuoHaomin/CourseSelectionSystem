package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import org.hibernate.SessionFactory;

public class TeacherImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public TeacherEntity getTeacher(String teacher_id){

        return null;
    }

    /**
     * Add a teacher to the database
     * @param teacher teacher's information
     */
    public void addTeacher(TeacherEntity teacher){
        sessionFactory.inTransaction(session -> {
            session.persist(teacher);
        });
    }

    /**
     * Update the teacher's information
     * @param teacher teacher's information
     */
    public void updateTeacher(TeacherEntity teacher) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(
                            "update TeacherEntity set name = :name, password = :password," +
                                    " phoneNumber = :phoneNumber, gender = :gender where " +
                                    "id = :id")
                    .setParameter("name", teacher.getName())
                    .setParameter("password", teacher.getPassword())
                    .setParameter("phoneNumber", teacher.getPhoneNumber())
                    .setParameter("gender", teacher.getGender())
                    .setParameter("id", teacher.getId())
                    .executeUpdate();
        });
    }
}
