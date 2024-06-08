package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Database.CourseImpl;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;

import java.util.List;

public class CourseService {
    /**
     * 课程id
     */
    int id;

    public CourseService(int id) {
        this.id = id;
    }


    /**
     * 获得课程中的学生id列表
     * @return id列表
     */
    public List<String> GetStudentInCourse(){
        StudentCourse studentCourse = new StudentCourse();
        return studentCourse.GetStudentList(id);
    }

    /**
     * 获得课程信息
     * @return 课程信息
     */
    public CourseEntity GetCourseInfo(){
        CourseImpl courseEditor = new CourseImpl();
        return courseEditor.GetCourseInfo(id);
    }

    public Integer GetNumberOfStudentsInCourse(){
        CourseImpl courseEditor = new CourseImpl();
        return courseEditor.GetNumberOfStudentsInCourse(id);
    }
}
