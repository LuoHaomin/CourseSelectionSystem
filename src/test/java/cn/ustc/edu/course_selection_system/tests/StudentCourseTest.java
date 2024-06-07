package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import org.junit.jupiter.api.Test;

public class StudentCourseTest {
    @Test
    public void testAddCoursePair() {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.AddCoursePair("2019211001", 1);
        studentCourse.AddCoursePair("2019211002", 2);
        studentCourse.AddCoursePair("2019211001", 3);
    }

    @Test
    public void testGetStudentScore() {
        StudentCourse studentCourse = new StudentCourse();
        System.out.println(studentCourse.GetStudentScore("2019211001", 1));
    }


    @Test
    public void testChangeScore() {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.ChangeScore("2019211001", 1, 90.0);
    }

    @Test
    public void testGetStudentList(){
        StudentCourse studentCourse = new StudentCourse();
        System.out.println(studentCourse.GetStudentList(3).toString());
    }

    @Test
    public void testImportScore(){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.ImportScore("2019211001", 1, 97.0);
    }
}
