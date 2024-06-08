package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourse {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Add a course to the teacher's course list
     * @param teacherId teacher's id
     * @param courseId course's id
     */
    public void AddCoursePair(String teacherId, int courseId) {
        TeacherCourseEntity teacherCourseEntity = new TeacherCourseEntity();
        teacherCourseEntity.setTeacherId(teacherId);
        teacherCourseEntity.setCourseId(courseId);
        sessionFactory.inTransaction(session -> {
            session.persist(teacherCourseEntity);
        });
    }

    /**
     * Delete a course from the teacher's course list
     * @param teacherId teacher's id
     * @param courseId course's id
     */
    public void DeleteCoursePair(String teacherId, int courseId) {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery("delete from TeacherCourseEntity where " +
                            "teacherId = :teacherId and courseId = :courseId")
                    .setParameter("teacherId", teacherId)
                    .setParameter("courseId", courseId)
                    .executeUpdate();
        });
    }

    /**
     * Get the teacher's teaching course list
     * @param teacherId teacher's id
     * @return the teacher's teaching course list
     */
    public List<TeacherCourseEntity> GetTeachingCourseList(String teacherId) {
        List<TeacherCourseEntity> teacherCourseList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<TeacherCourseEntity> _teacherCourseList = session.createQuery("from " +
                                    "TeacherCourseEntity where teacherId = :teacherId",
                            TeacherCourseEntity.class)
                    .setParameter("teacherId", teacherId)
                    .getResultList();
            teacherCourseList.addAll(_teacherCourseList);
        });
        return teacherCourseList;
    }

    /**
     * Get the teachers of a course
     * @param courseId course's id
     * @return the teachers of the course
     */
    public List<TeacherEntity> GetTeachersOfCourse(int courseId){
        List<TeacherEntity> teacherList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<TeacherEntity> _teacherCourseList = session.createQuery("from " +
                            "TeacherEntity where id in (select teacherId from TeacherCourseEntity " +
                            "where courseId = :courseId)",
                    TeacherEntity.class)
                    .setParameter("courseId", courseId)
                    .getResultList();
            teacherList.addAll(_teacherCourseList);
        });
        return teacherList;
    }

    @Deprecated
    public List<TeacherCourseEntity> GetTeachingCourseAllList(Integer page, Integer ItemPerPage) {
        return null;
    }
    @Deprecated
    public List<TeacherCourseEntity> GetTeachingCourseAllList() {
        return null;
    }

    @Deprecated
    public Integer GetTeachingCourseNum() {
        return 0;
    }

}
