package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Database.CourseEditorImpl;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;
import cn.ustc.edu.course_selection_system.Util.CourseTable;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService
{
    String id;
    public StudentService(String id){
        this.id = id;
    }

    /**
     * 获得学生信息
     * @return 学生信息
     */
    public StudentEntity GetID() {
        StudentImpl studentImpl = new StudentImpl();

        return studentImpl.getStudent(id);
    }

    /**
     * 更新学生信息
     * @param studentEntity 学生信息
     * @return 是否成功
     */
    public boolean updateID(StudentEntity studentEntity) {
        if(studentEntity.getId() == null){
            return false;
        }

        StudentImpl studentImpl = new StudentImpl();
        try {
            studentImpl.updateStudent(studentEntity);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    public List<CourseEntity> getRelatedCourse() {
        StudentCourse studentCourse = new StudentCourse();
        return studentCourse.GetChosenCourseList(id);
    }


    /**
     * 获得课程表数据
     */
    public List<Objects> getSchedule(){
        return List.of();
    }

    /**
     * 获得培养方案（待选课程列表）
     * @return 待选课程列表
     */
    public List<Integer> getProgram(){
        return List.of();
    }

    /**
     * 选课
     * @return 是否成功
     */
    public boolean chooseCourse(int courseId){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        CourseEntity courseEntity = courseEditor.GetCourseInfo(courseId);
        //课程不存在
        if(courseEntity == null){
            return false;
        }
        //判断是否重叠
        CourseTable courseTable = new CourseTable(getRelatedCourse());
        if((courseTable.IsConflicted(courseEntity))){
            //Todo：改为丢异常
            return false;
        }
        //判断是否超过人数上限
        if(courseEditor.GetNumberOfStudentsInCourse()>=courseEntity.getCapacity()){
            return false;
        }

        StudentCourse studentCourse = new StudentCourse();
        studentCourse.AddCoursePair(id,courseId);
        return true;
    }

    /**
     * 退课
     * @return 是否成功
     */
    public boolean dropCourse(int courseId){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.DeleteCoursePair(id,courseId);
        return true;
    }

    /**
     * 获得课程编号—分数
     * @return 课程编号—分数对列表
     */
    public List<Pair<Integer,Integer> > getScore(){

        return List.of();
    }

}
