package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.MajorCourseEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class DisciplinaryPlanData {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public void AddDisciplinaryPlan(String major, String courseNumber) {
        MajorCourseEntity majorCourseEntity = new MajorCourseEntity();
        majorCourseEntity.setMajor(major);
        majorCourseEntity.setCourseNumber(courseNumber);
        sessionFactory.inTransaction(session -> {
            session.persist(majorCourseEntity);
        });
    }

    public void DelDisciplinaryPlan(String major, String courseNumber) {

    }

    public List<MajorCourseEntity> GetDisciplinaryPlan(String major) {
        return null;
    }

}
