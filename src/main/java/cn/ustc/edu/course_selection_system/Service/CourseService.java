package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Database.CourseEditorImpl;

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
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        return courseEditor.GetStudentList(id);
    }

    /**
     * 获得课程信息
     * @return 课程信息
     */
    public CourseEntity GetCourseInfo(){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        return courseEditor.GetCourseInfo(id);
    }

}
