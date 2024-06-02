import cn.ustc.edu.course_selection_system.Bean.StudentEntity;

import java.lang.module.Configuration;

public class sessionTest {
    public static void main(String[] args) {
        System.out.println("Test for session");
        StudentEntity student = new StudentEntity();
        student.setMajor("Computer Science");
        student.setPassword("123456");
        student.setName("Tom");
        student.setAdmissionYear(2020);
        student.setPosition("Student");

        Configuration configuration = java.lang.module.Configuration.empty();
    }
}
