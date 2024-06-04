package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;
import javafx.util.Pair;

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

    public List<Integer> getRelatedCourse() {
        return List.of();
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
    public boolean chooseCourse(){
        return false;
    }

    /**
     * 退课
     * @return 是否成功
     */
    public boolean dropCourse(){
        return false;
    }

    /**
     * 获得课程编号—分数
     * @return 课程编号—分数对列表
     */
    public List<Pair<Integer,Integer> > getScore(){
        return List.of();
    }

}
