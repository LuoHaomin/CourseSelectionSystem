package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import javafx.util.Pair;

import java.util.List;

public class TeacherService extends AbstractPersonService{
    @Override
    public StudentEntity GetID() {
        return null;
    }

//    @Override
//    public boolean updateID(PersonInfo personInfo) {
//        return false;
//    }

    @Override
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
