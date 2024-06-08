package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.MajorCourseEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaryPlanData {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /**
     * Add a disciplinary plan
     * @param major major
     * @param courseNumber course number
     */
    public void AddDisciplinaryPlan(String major, String courseNumber) {
        MajorCourseEntity majorCourseEntity = new MajorCourseEntity();
        majorCourseEntity.setMajor(major);
        majorCourseEntity.setCourseNumber(courseNumber);
        sessionFactory.inTransaction(session -> {
            session.persist(majorCourseEntity);
        });
    }

    /**
     * Delete a disciplinary plan
     * @param major major
     * @param courseNumber course number
     */
    public void DelDisciplinaryPlan(String major, String courseNumber) {
        MajorCourseEntity majorCourseEntity = new MajorCourseEntity();
        majorCourseEntity.setMajor(major);
        majorCourseEntity.setCourseNumber(courseNumber);
        sessionFactory.inTransaction(session -> {
            session.remove(majorCourseEntity);
        });
    }

    /**
     * Get the disciplinary plan
     * @param major major
     * @return List<MajorCourseEntity>
     */
    public List<MajorCourseEntity> GetDisciplinaryPlan(String major) {
        List<MajorCourseEntity> majorCourseList = new ArrayList<>();
        sessionFactory.inSession(session -> {
            List<MajorCourseEntity> _majorCourseList = session.createQuery("from MajorCourseEntity where major = :major",
                            MajorCourseEntity.class)
                    .setParameter("major", major)
                    .getResultList();
            majorCourseList.addAll(_majorCourseList);
        });
        return majorCourseList;
    }

}
