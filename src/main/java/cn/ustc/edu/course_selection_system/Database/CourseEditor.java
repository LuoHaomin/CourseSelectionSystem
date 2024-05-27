package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.CourseinfoEntity;

public interface CourseEditor {
    void AddCourse();
    void DelCourse();
    CourseinfoEntity GetCourseInfo(int id);
    void UpdateCourseInfo();
}
