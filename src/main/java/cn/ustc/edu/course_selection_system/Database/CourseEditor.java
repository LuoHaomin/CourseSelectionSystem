package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseInfo;

public interface CourseEditor {
    void AddCourse();
    void DelCourse();
    CourseInfo GetCourseInfo(int id);
    void UpdateCourseInfo();
}
