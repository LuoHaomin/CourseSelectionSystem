package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseEditorImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public int AddCourse(String number, String time, float credit, String periods, int capacity) {
        CourseEntity course = new CourseEntity();
        course.setNumber(number);
        course.setTime(time);
        course.setCredit(credit);
        course.setPeriods(periods);
        course.setCapacity(capacity);
        sessionFactory.inTransaction(session -> {
            session.persist(course);
        });
        return 0;
    }


    public void DelCourse(int courseId) {

    }

    public Integer GetNumberOfStudentsInCourse(){
        return 0;
    }

    public CourseEntity GetCourseInfo(int courseId) {
        return null;
    }

    public void UpdateCourseInfo(int courseId, String number, String time, float credit, String periods, int capacity) {

    }
    public List<String> GetStudentList(int courseId) {
        return null;
    }
    public List<String> GetTeacherList(int courseId) {
        return null;
    }
}
