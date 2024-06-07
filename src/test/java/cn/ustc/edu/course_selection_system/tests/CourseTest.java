package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Database.CourseEditorImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    @Test
    public void testAddCourse(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        courseEditor.AddCourse("数分", "周一", 3, "1-14周", 80);
    }

    @Test
    public void testDelCourse(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        courseEditor.DelCourse(2);
    }

    @Test
    public void testFindByCourseName(){
        List<CourseEntity> courses = new ArrayList<>();
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        courses = courseEditor.FindByCourseName("数分");
        for (CourseEntity course : courses) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void testGetNumberOfStudentsInCourse(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        int num = courseEditor.GetNumberOfStudentsInCourse(3);
        System.out.println(num);
    }

    @Test
    public void testGetCourseInfo(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        CourseEntity course = courseEditor.GetCourseInfo(3);
        System.out.println(course.toString());
    }

    @Test
    public void testUpdateCourseInfo(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        CourseEntity course = courseEditor.GetCourseInfo(3);
        course.setCapacity(100);
        courseEditor.UpdateCourseInfo(3, "数分", "周一", 3, "1-14周", 100);
    }
}
