package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.CourseEditorImpl;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;
import javafx.util.Pair;

import java.util.List;

public class TeacherService {
    String id;
    public TeacherService(String id) {
        this.id = id;
    }

    public TeacherEntity GetID() {
        TeacherImpl teacherImpl = new TeacherImpl();
        return teacherImpl.getTeacher(id);
    }


    public boolean updateID(TeacherEntity teacherEntity) {
        TeacherImpl teacherImpl = new TeacherImpl();
        teacherImpl.updateTeacher(teacherEntity);
        return true;
    }

    public List<CourseEntity> getRelatedCourse() {
        TeacherCourse teacherCourse = new TeacherCourse();
        return teacherCourse.GetTeachingCourseList(id);
    }

    public boolean AddCourse(CourseEntity courseInfo){
        CourseEditorImpl courseEditor  = new CourseEditorImpl();
        courseEditor.AddCourse(courseInfo);
        return true;
    }

    public boolean delCourse(int course_id){
        CourseEditorImpl courseEditor = new CourseEditorImpl();
        courseEditor.DelCourse(course_id);
        //TODO: 关联键
        return false;
    }

    public int importStudentsScore(Integer courseID,List< Pair<String,Float> > scorelist){
        StudentCourse studentCourse = new StudentCourse();
        for(Pair<String,Float> score : scorelist) {
            studentCourse.ChangeScore(score.getKey(),courseID,score.getValue());
        }
        return scorelist.size();
    }

    public boolean changeScore(Integer courseID,Pair<String,Double> score){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.ChangeScore(score.getKey(),courseID,score.getValue());
        return false;
    }


}
