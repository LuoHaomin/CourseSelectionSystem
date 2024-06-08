package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    public void testGetTeacher(){
        TeacherImpl teacherImpl = new TeacherImpl();
        TeacherEntity teacher = new TeacherEntity();
        teacher = teacherImpl.getTeacher("1");
        System.out.println(teacher.getName());
    }

    @Test
    public void testAddTeacher(){
        TeacherImpl teacherImpl = new TeacherImpl();
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId("1");
        teacher.setName("test");
        teacher.setPassword("123456");
        teacher.setPhoneNumber("12345678901");
        teacher.setGender("男");
        teacherImpl.addTeacher(teacher);
    }

    @Test
    public void testUpdateTeacher(){
        TeacherImpl teacherImpl = new TeacherImpl();
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId("1");
        teacher.setName("李老师");
        teacher.setPassword("123456");
        teacher.setPhoneNumber("12345678901");
        teacher.setGender("男");
        teacherImpl.updateTeacher(teacher);
    }


}
