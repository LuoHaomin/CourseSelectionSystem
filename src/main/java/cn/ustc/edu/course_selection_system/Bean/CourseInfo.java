package cn.ustc.edu.course_selection_system.Bean;

import java.util.List;

public class CourseInfo {
    CourseEntity courseEntity;
    List<TeacherEntity> teacherEntity;


    public CourseInfo(CourseEntity courseEntity, List<TeacherEntity> teacherEntity) {
        this.courseEntity = courseEntity;
        this.teacherEntity = teacherEntity;
    }


}
