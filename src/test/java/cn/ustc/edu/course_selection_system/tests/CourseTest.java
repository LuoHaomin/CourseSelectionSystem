package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Database.CourseImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    @Test
    public void testAddCourse(){
        CourseImpl courseEditor = new CourseImpl();
        courseEditor.AddCourse("数分", "周一", 3, "1-14周", 80);
    }

    @Test
    public void testDelCourse(){
        CourseImpl courseEditor = new CourseImpl();
        courseEditor.DelCourse(2);
    }

    @Test
    public void testFindByCourseName(){
        List<CourseEntity> courses = new ArrayList<>();
        CourseImpl courseEditor = new CourseImpl();
        courses = courseEditor.FindByCourseName("数分");
        for (CourseEntity course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void testGetNumberOfStudentsInCourse(){
        CourseImpl courseEditor = new CourseImpl();
        int num = courseEditor.GetNumberOfStudentsInCourse(3);
        System.out.println(num);
    }

    @Test
    public void testGetCourseInfo(){
        CourseImpl courseEditor = new CourseImpl();
        CourseEntity course = courseEditor.GetCourseInfo(3);
        System.out.println(course.toString());
    }

    @Test
    public void testUpdateCourseInfo(){
        CourseImpl courseEditor = new CourseImpl();
        CourseEntity course = courseEditor.GetCourseInfo(3);
        course.setCapacity(100);
        courseEditor.UpdateCourseInfo(3, "数分", "周一", 3, "1-14周", 100);
    }
}
