package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntity;

import java.util.List;

public class TeacherCourse {
    public int AddCoursePair(String teacherId, int courseId) {
        return 0;
    }


    public void DeleteCoursePair(String teacherId, int courseId) {

    }

    public List<TeacherCourseEntity> GetTeachingCourseList(String teacherId) {
        return null;
    }
    public List<TeacherCourseEntity> GetTeachingCourseAllList(Integer page, Integer ItemPerPage) {
        return null;
    }
    public List<TeacherCourseEntity> GetTeachingCourseAllList() {
        return null;
    }

    public Integer GetTeachingCourseNum() {
        return 0;
    }

    public List<String> GetTeacherList(int courseId) {
        return null;
    }
}
