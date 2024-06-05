package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentCourse {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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

    public List<CourseEntity> GetChosenCourseList(String studentId) {

//        StudentEntity student = session.get(StudentEntity.class, id);
        return null;
    }
    public float GetStudentScore(String studentId, int courseId) {

        return 0;
    }

    public void ImportScore(String studentId, int courseId, float score) {

    }

    public void ChangeScore(String studentId, int courseId, float score) {

    }
}
