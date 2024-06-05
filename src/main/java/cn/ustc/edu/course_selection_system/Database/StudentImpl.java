package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentImpl{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void insertStudent(StudentEntity studentEntity){

    }
    public StudentEntity getStudent(String id){
        return null;
    }
    public void updateStudent(StudentEntity student){

    }




}
