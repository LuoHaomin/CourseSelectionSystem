package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void testAddStudent() {
        StudentImpl studentImpl = new StudentImpl();
        studentImpl.addStudent("2019211001", "张三", "123456", "12345678901", "软件工程", 2019, "男");
        studentImpl.addStudent("2019211002", "李四", "123453", "12345678902", "软件工程", 2019, "女");
        studentImpl.addStudent("2019211003", "王五", "123452", "12345678903", "软件工程", 2019, "男");
    }

    @Test
    public void testGetStudent() {
        StudentImpl studentImpl = new StudentImpl();
        StudentEntity student = studentImpl.getID("2019211001");
        System.out.println(student.toString());
    }

    @Test
    public void testUpdateStudent() {
        StudentImpl studentImpl = new StudentImpl();
        StudentEntity student = studentImpl.getID("2019211001");
        student.setGender("无");
        studentImpl.updateStudent(student);
    }

    @Test
    public void testDeleteStudent() {
        StudentImpl studentImpl = new StudentImpl();
        studentImpl.deleteStudent("2019211001");
    }

    @Test
    public void testAddCoursePair() {
        StudentImpl studentImpl = new StudentImpl();
        studentImpl.AddCoursePair("2019211001", 1);
        studentImpl.AddCoursePair("2019211002", 2);
        studentImpl.AddCoursePair("2019211001", 3);
    }

    @Test
    public void testDeleteCoursePair() {
        StudentImpl studentImpl = new StudentImpl();
        studentImpl.DeleteCoursePair("2019211001", 3);
    }

    @Test
    public void testFindWithConstraint() {
        StudentImpl studentImpl = new StudentImpl();
        String test = "%";
        List<StudentEntity> studentList = studentImpl.FindWithConstraint("%", "%", test);
        for (StudentEntity student : studentList) {
            System.out.println(student.toString());
        }
    }
}
