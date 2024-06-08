package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Database.DisciplinaryPlanData;
import org.junit.jupiter.api.Test;

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
        System.out.println(disciplinaryPlanData.GetDisciplinaryPlan("软件工程"));
    }
}
