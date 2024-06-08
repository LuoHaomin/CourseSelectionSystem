package cn.ustc.edu.course_selection_system.Bean;

public class CourseInfo {
    CourseEntity courseEntity;
    TeacherEntity teacherEntity;


    public CourseInfo(CourseEntity courseEntity, TeacherEntity teacherEntity) {
        this.courseEntity = courseEntity;
        this.teacherEntity = teacherEntity;
    }


}
