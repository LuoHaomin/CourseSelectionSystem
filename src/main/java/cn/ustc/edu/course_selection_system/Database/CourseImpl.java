package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseImpl {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Add a course to the database
     * @param name the name of the course
     * @param time the time of the course
     * @param credit the credit of the course
     * @param periods the periods of the course
     * @param capacity the capacity of the course
     * @return the id of the course
     */
    public int AddCourse(String name, String time, float credit, String periods, int capacity) {
        CourseEntity course = new CourseEntity();
        course.setName(name);
        course.setTime(time);
        course.setCredit(credit);
        course.setPeriods(periods);
        course.setCapacity(capacity);
        sessionFactory.inTransaction(session -> {
            session.persist(course);
        });
        return course.getId();
    }

    /**
     * Add a course to the database
     * @param info the course entity
     */
    public void AddCourse(CourseEntity info) {
        sessionFactory.inTransaction(session -> {
            session.persist(info);
        });
    }

    /**
     * Delete a course from the database
     * @param courseId the id of the course
     */
    public void DelCourse(int courseId) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("delete from StudentCourseEntity where courseId = :id")
                    .setParameter("id", courseId)
                    .executeUpdate();
            session.createMutationQuery("delete from CourseEntity where id = :id")
                    .setParameter("id", courseId)
                    .executeUpdate();
        });
    }

    /**
     * Find a course by its name
     * @param name the name of the course
     * @return a list of courses with the same name
     */
    public List<CourseEntity> FindByCourseName(String name) {
        List<CourseEntity> courses = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
             courses.addAll(session.createQuery("from CourseEntity where name = :name", CourseEntity.class)
                    .setParameter("name", name)
                    .getResultList());
        });
        return courses;
    }

    /**
     * Get the number of students in a course
     * @param courseId the id of the course
     * @return the number of students in the course
     */
    public Integer GetNumberOfStudentsInCourse(int courseId){
        List<Long> numberInCourse = new ArrayList<>();
        sessionFactory.inSession(session -> {
            numberInCourse.addAll(session.createQuery("select count(*) from StudentCourseEntity where courseId = :courseId",
                            Long.class)
                    .setParameter("courseId", courseId)
                    .getResultList());
        });
        return numberInCourse.get(0).intValue();
    }

    /**
     * Get the information of a course by its id
     * @param courseId the id of the course
     * @return the course entity
     */
    public CourseEntity GetCourseInfo(int courseId) {
        List<CourseEntity> courses = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<CourseEntity> _courses = session.createQuery("from CourseEntity where id = :id", CourseEntity.class)
                    .setParameter("id", courseId)
                    .getResultList();
            courses.addAll(_courses);
        });
        return courses.get(0);
    }

    /**
     * Update the information of a course
     * @param courseId the id of the course
     * @param name the name of the course
     * @param time the time of the course
     * @param credit the credit of the course
     * @param periods the periods of the course
     * @param capacity the capacity of the course
     */
    public void UpdateCourseInfo(int courseId, String name, String time, float credit, String periods, int capacity) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(
                    "update CourseEntity set name = :name, time = :time, credit = :credit," +
                            " periods = :periods, capacity = :capacity where id = :courseId")
                    .setParameter("name", name)
                    .setParameter("time", time)
                    .setParameter("credit", credit)
                    .setParameter("periods", periods)
                    .setParameter("capacity", capacity)
                    .setParameter("courseId", courseId)
                    .executeUpdate();
        });
    }

    public List<CourseEntity> getAllCourses(){
        return null;
    }

    public Integer getNumberOfCourses(){
        return 1;
    }

    /**
     *
     * @param page
     * @param limit maximum items in a page
     * @return
     */
    public List<CourseEntity> getAllCourses(int page, int limit){
        return null;
    }
}
