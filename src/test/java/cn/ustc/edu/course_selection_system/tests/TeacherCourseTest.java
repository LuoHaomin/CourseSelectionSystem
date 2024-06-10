package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.TeacherCourse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourseTest {
    @Test
    public void testAddCoursePair(){
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.AddCoursePair("1", 4);
//        teacherCourse.AddCoursePair("123", 5);
    }

    @Test
    public void testDeleteCoursePair(){
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.DeleteCoursePair("1", 4);
    }

    @Test
    public void testGetTeachingCourseList(){
        TeacherCourse teacherCourse = new TeacherCourse();
        List<TeacherCourseEntity> teacherCourseList = new ArrayList<>();
        teacherCourseList = teacherCourse.GetTeachingCourseList("123");
        System.out.println(teacherCourseList.toString());
    }

    @Test
    public void testGetTeachersOfCourse(){
        TeacherCourse teacherCourse = new TeacherCourse();
        List<TeacherEntity> teacherList = new ArrayList<>();
        teacherList = teacherCourse.GetTeachersOfCourse(4);
        System.out.println(teacherList.toString());
    }
}
