package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.MajorCourseEntity;
import cn.ustc.edu.course_selection_system.Database.DisciplinaryPlanData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MajorCourseTest {
    @Test
    public void testAddDisciplinaryPlan() {
        DisciplinaryPlanData disciplinaryPlanData = new DisciplinaryPlanData();
        disciplinaryPlanData.AddDisciplinaryPlan("软件工程", "C++");
        disciplinaryPlanData.AddDisciplinaryPlan("软件工程", "Java");
        disciplinaryPlanData.AddDisciplinaryPlan("软件工程", "Python");
    }

    @Test
    public void testGetDisciplinaryPlan() {
        DisciplinaryPlanData disciplinaryPlanData = new DisciplinaryPlanData();
        List<MajorCourseEntity> majorCourseList = new ArrayList<>();
        majorCourseList = disciplinaryPlanData.GetDisciplinaryPlan("软件工程");
        for (MajorCourseEntity majorCourseEntity : majorCourseList) {
            System.out.println(majorCourseEntity.getCourseNumber());
        }
    }

    @Test
    public void testDelDisciplinaryPlan() {
        DisciplinaryPlanData disciplinaryPlanData = new DisciplinaryPlanData();
        disciplinaryPlanData.DelDisciplinaryPlan("软件工程", "C++");
    }
}
