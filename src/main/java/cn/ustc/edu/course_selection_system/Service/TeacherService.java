package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import javafx.util.Pair;

import java.util.List;

public class TeacherService {
    String id;
    public TeacherService(String id) {
        this.id = id;
    }

    public TeacherEntity GetID() {
        return null;
    }

//    @Override
//    public boolean updateID(PersonInfo personInfo) {
//        return false;
//    }

    public List<Integer> getRelatedCourse() {
        return List.of();
    }

    public boolean AddCourse(CourseEntity courseInfo){
        return false;
    }

    public boolean delCourse(int course_id){
        return false;
    }

    public int importStudentsScore(List< Pair<Integer,Integer> > scorelist){

        return 0;
    }

    public boolean changeScore(Pair<Integer,Integer> score){
        return false;
    }


}
