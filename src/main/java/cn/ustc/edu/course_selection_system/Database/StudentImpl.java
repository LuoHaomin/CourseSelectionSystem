package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import org.hibernate.SessionFactory;

public class StudentImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//    Session session = null;
//    Transaction transaction = null;

//    public void StartSession(){
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//        } catch (HibernateException e) {
////            e.printStackTrace();
//            transaction.rollback();
//            System.out.println("Failed to start a session!");
//        }
//    }
//
//    private void CloseSession(){
//        try {
//            transaction.commit();
//            session.close();
//        } catch (HibernateException e) {
////            e.printStackTrace();
//            transaction.rollback();
//            System.out.println("Failed to close a session!");
//        }
//    }
    public StudentEntity getStudent(String id){
        return null;
    }

    public void AddCoursePair(String studentId, int courseId) {
        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.persist(studentCourse);
        });
    }

    public void DeleteCoursePair(String studentId, int courseId) {
        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.delete(session.get(StudentCourseEntity.class, studentCourse));
        });

    }

    public void GetChosenCourseList(String studentId) {

//        StudentEntity student = session.get(StudentEntity.class, id);

    }

    public float GetStudentScore(String studentId, int courseId) {
        return 0;
    }

    public void ImportScore(String studentId, int courseId, float score) {

    }

    public void ChangeScore(String studentId, int courseId, float score) {

    }
}
