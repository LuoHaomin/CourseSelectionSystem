package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import cn.ustc.edu.course_selection_system.Bean.StudentinfoEntity;
import cn.ustc.edu.course_selection_system.Database.PersonalInfoEditorImpl;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class StudentService extends AbstractPersonService {

    public StudentService(int id){
        this.id = id;
    }

    @Override
    public StudentinfoEntity GetID() {
        PersonalInfoEditorImpl idEditor = new PersonalInfoEditorImpl();
        return (StudentinfoEntity) idEditor.GetPersonalInfo(this.id);
    }

    @Override
    public boolean updateID(PersonInfo personInfo) {
        return false;
    }

    @Override
    public List<Integer> getRelatedCourse() {
        return List.of();
    }

    /**
     * 获得课程表数据
     */
    public void getSchedule(){

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
