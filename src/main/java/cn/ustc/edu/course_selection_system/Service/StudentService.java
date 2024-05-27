package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import cn.ustc.edu.course_selection_system.Bean.StudentinfoEntity;
import cn.ustc.edu.course_selection_system.Database.PersonalInfoEditorImpl;

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

    public List<Integer> getProgram(){
        return List.of();
    }

    public boolean chooseCourse(){
        return false;
    }

    public boolean dropCourse(){
        return false;
    }

    public int getScore(){
        return 0;
    }

}
