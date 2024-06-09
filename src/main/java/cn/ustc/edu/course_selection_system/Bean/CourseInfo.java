package cn.ustc.edu.course_selection_system.Bean;

import cn.ustc.edu.course_selection_system.Database.TeacherImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseInfo {
    CourseEntity courseEntity;
    List<TeacherEntity> teacherEntity;

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public List<TeacherEntity> getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(List<TeacherEntity> teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public CourseInfo(CourseEntity courseEntity, List<TeacherEntity> teacherEntity) {
        this.courseEntity = courseEntity;
        this.teacherEntity = teacherEntity;
    }
    public CourseInfo(){
        this.courseEntity = new CourseEntity("newCourse","Mon(1,2,3)",2,"1-16",120);

        this.teacherEntity = new ArrayList<TeacherEntity>();
    }

    public String getCourseName() {
        return courseEntity.getName();
    }
    public void setCourseName(String courseName) {
        courseEntity.setName(courseName);
    }

    public String getTeacher() {
        StringBuilder teacher = new StringBuilder();
        for (TeacherEntity teacherEntity : teacherEntity) {
            teacher.append(",").append(teacherEntity.getName());
        }
        return teacher.toString();
    }
    public void setTeacher(String teacher) {
        TeacherImpl teacherImpl = new TeacherImpl();
        String[] split = teacher.split(",");
        for (String s : split) {
            TeacherEntity newTeacherEntity=teacherImpl.getTeacher(s);
            if (newTeacherEntity!=null){
                this.teacherEntity.add(newTeacherEntity);
            }
        }

    }
    public String getTime() {
        return courseEntity.getTime();
    }
    public void setTime(String time) {
        courseEntity.setTime(time);
    }
    public String getPeriod() {
        return courseEntity.getPeriods();
    }
    public void setPeriod(String period) {
        courseEntity.setPeriods(period);
    }
    public Double getCredit(){
        return courseEntity.getCredit();
    }
    public void setCredit(Double credit) {
        courseEntity.setCredit(credit);
    }
    public Integer getCapacity(){
        return courseEntity.getCapacity();
    }
    public void setCapacity(Integer capacity) {
        courseEntity.setCapacity(capacity);
    }
}
