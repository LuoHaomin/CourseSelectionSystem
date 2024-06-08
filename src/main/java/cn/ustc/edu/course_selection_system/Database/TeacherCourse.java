package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class TeacherCourse {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public void AddCoursePair(String teacherId, int courseId) {
        TeacherCourseEntity teacherCourseEntity = new TeacherCourseEntity();
        teacherCourseEntity.setTeacherId(teacherId);
        teacherCourseEntity.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.persist(teacherCourseEntity);
        });
    }

    public void DeleteCoursePair(String teacherId, int courseId) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("delete from TeacherCourseEntity where " +
                            "teacherId = :teacherId and courseId = :courseId")
                    .setParameter("teacherId", teacherId)
                    .setParameter("courseId", courseId)
                    .executeUpdate();
        });
    }

    public List<TeacherCourseEntity> GetTeachingCourseList(String teacherId) {
        return null;
    }

    public List<TeacherCourseEntity> GetTeachersOfCourse(int courseId){
        return null;
    }

    @Deprecated
    public List<TeacherCourseEntity> GetTeachingCourseAllList(Integer page, Integer ItemPerPage) {
        return null;
    }
    @Deprecated
    public List<TeacherCourseEntity> GetTeachingCourseAllList() {
        return null;
    }

    public Integer GetTeachingCourseNum() {
        return 0;
    }

    public List<String> GetTeacherList(int courseId) {
        return null;
    }
}
