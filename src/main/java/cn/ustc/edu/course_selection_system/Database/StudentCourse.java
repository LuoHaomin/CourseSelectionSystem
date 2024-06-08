package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntityPK;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentCourse {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Add a course to the student's course list
     * @param studentId student's id
     * @param courseId course's id
     */
    public void AddCoursePair(String studentId, int courseId) {
        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        studentCourse.setScore(0.0);
        sessionFactory.inTransaction(session -> {
            session.persist(studentCourse);
        });
    }

    /**
     * Delete a course from the student's course list
     * @param studentId student's id
     * @param courseId course's id
     */
    public void DeleteCoursePair(String studentId, int courseId) {
        StudentCourseEntityPK studentCourseEntityPK = new StudentCourseEntityPK();
        studentCourseEntityPK.setStudentId(studentId);
        studentCourseEntityPK.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.remove(session.get(StudentCourseEntity.class, studentCourseEntityPK));
        });
    }

    /**
     * Get the student's chosen course list
     * @param studentId student's id
     * @return List<CourseEntity>
     */
    public List<CourseEntity> GetChosenCourseList(String studentId) {
        List<CourseEntity> courseList = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            List<CourseEntity> _courseList = session.createQuery("from CourseEntity where id in (select courseId from " +
                            "StudentCourseEntity where studentId = :studentId)", CourseEntity.class)
                    .setParameter("studentId", studentId)
                    .getResultList();
            courseList.addAll(_courseList);
        });
        return courseList;
    }

    /**
     * Get the student's score of a course
     * @param studentId student's id
     * @param courseId course's id
     * @return Double score
     */
    public Double GetStudentScore(String studentId, int courseId) {
        List<Double> score = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            List<Double> _score = session.createQuery("select score from StudentCourseEntity where " +
                            "studentId = :studentId and courseId = :courseId", Double.class)
                    .setParameter("studentId", studentId)
                    .setParameter("courseId", courseId)
                    .getResultList();
            score.addAll(_score);
        });
        return score.get(0);
    }

    /**
     * Import the student's score of a course
     * @param studentId student's id
     * @param courseId course's id
     * @param score score
     */
    public void ImportScore(String studentId, int courseId, double score) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("update StudentCourseEntity set " +
                            "score = :score where studentId = :studentId and " +
                            "courseId = :courseId")
                    .setParameter("score", score)
                    .setParameter("studentId", studentId)
                    .setParameter("courseId", courseId)
                    .executeUpdate();
        });
    }

    /**
     * Change the student's score of a course
     * @param studentId student's id
     * @param courseId course's id
     * @param score new score
     */
    public void ChangeScore(String studentId, int courseId, double score) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("update StudentCourseEntity set " +
                            "score = :score where studentId = :studentId and " +
                            "courseId = :courseId")
                    .setParameter("score", score)
                    .setParameter("studentId", studentId)
                    .setParameter("courseId", courseId)
                    .executeUpdate();
        });
    }

    /**
     * Get the student list of a course
     * @param courseId course's id
     * @return List<String> student list
     */
    public List<String> GetStudentList(int courseId) {
        List<String> studentList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<String> _studentList = session.createQuery("select studentId from " +
                            "StudentCourseEntity where courseId = :courseId", String.class)
                    .setParameter("courseId", courseId)
                    .getResultList();
            studentList.addAll(_studentList);
        });
        return studentList;
    }

}
