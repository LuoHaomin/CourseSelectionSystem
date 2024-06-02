package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

public interface CourseEditor {
    void AddCourse();
    void DelCourse();
    CourseEntity GetCourseInfo(int id);
    void UpdateCourseInfo();
}
