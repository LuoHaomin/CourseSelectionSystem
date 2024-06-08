package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public TeacherEntity getTeacher(String teacher_id){
        List<TeacherEntity> teachers = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            List<TeacherEntity> _teachers = session.createQuery("from TeacherEntity where id = :id",
                            TeacherEntity.class)
                    .setParameter("id", teacher_id)
                    .getResultList();
            teachers.addAll(_teachers);
        });
        return teachers.get(0);
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

    public void deleteTeacher(String teacher_id){
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("delete from TeacherCourseEntity where " +
                            "teacherId = :teacherId")
                    .setParameter("teacherId", teacher_id)
                    .executeUpdate();
            session.createMutationQuery("delete from TeacherEntity where id = :id")
                    .setParameter("id", teacher_id)
                    .executeUpdate();
        });
    }
}
