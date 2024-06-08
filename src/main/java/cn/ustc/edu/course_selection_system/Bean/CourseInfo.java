package cn.ustc.edu.course_selection_system.Bean;

import java.util.List;

public class CourseInfo {
    CourseEntity courseEntity;
    List<TeacherEntity> teacherEntity;


    public CourseInfo(CourseEntity courseEntity, List<TeacherEntity> teacherEntity) {
        this.courseEntity = courseEntity;
        this.teacherEntity = teacherEntity;
    }

    public String getCourseName() {
        return courseEntity.getName();
    }
    public String getTeacher() {
        StringBuilder teacher = new StringBuilder();
        for (TeacherEntity teacherEntity : teacherEntity) {
            teacher.append(",").append(teacherEntity.getName());
        }
        return teacher.toString();
    }
    public String getTime() {
        return courseEntity.getTime();
    }
    public String getPeriod() {
        return courseEntity.getPeriods();
    }
    public Double getCredit(){
        return courseEntity.getCredit();
    }

}
