package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.CourseImpl;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    String id;

    public static final float EXCELLENT = 85f;
    public static final float LIMIT = 0.4f;

    public TeacherService(String id) {
        this.id = id;
    }

    public TeacherEntity GetID() {
        TeacherImpl teacherImpl = new TeacherImpl();
        return teacherImpl.getID(id);
    }


    public boolean updateID(TeacherEntity teacherEntity) {
        TeacherImpl teacherImpl = new TeacherImpl();
        teacherImpl.updateTeacher(teacherEntity);
        return true;
    }

    public List<CourseEntity> getRelatedCourse() {
        TeacherCourse teacherCourse = new TeacherCourse();
        List<TeacherCourseEntity> list =  teacherCourse.GetTeachingCourseList(id);
        CourseImpl courseEditor = new CourseImpl();
        List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();

        for (TeacherCourseEntity teacherCourseEntity : list) {
            CourseEntity courseEntity = courseEditor.GetCourseInfo(teacherCourseEntity.getCourseId());
            courseEntityList.add(courseEntity);
        }

        return courseEntityList;
    }

    public boolean AddCourse(CourseEntity courseEntity){
        CourseImpl courseEditor  = new CourseImpl();
        TeacherCourse teacherCourse = new TeacherCourse();
        int courseId = courseEditor.AddCourse(courseEntity);
        teacherCourse.AddCoursePair(id,courseId);
        return true;
    }

    public boolean delCourse(int course_id){
        CourseImpl courseEditor = new CourseImpl();
        try{
            courseEditor.DeleteCourse(course_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int importStudentsScore(Integer courseID,List< Pair<String,Double> > scorelist){
        StudentCourse studentCourse = new StudentCourse();
        for(Pair<String,Double> score : scorelist) {
            studentCourse.ChangeScore(score.getKey(),courseID,score.getValue());
        }
        return scorelist.size();
    }


    public boolean changeScore(Integer courseID,Pair<String,Double> score){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.ChangeScore(score.getKey(),courseID,score.getValue());
        return false;
    }

    public boolean excellentRate (int courseID,List<Pair<String,Double>> scorelist) {
        StudentCourse studentCourse = new StudentCourse();
        CourseService courseService = new CourseService(courseID);
        int excellent = 0;
        Integer sum = courseService.GetNumberOfStudentsInCourse();
        for (Pair<String, Double> score : scorelist)
            if (score.getValue() >= EXCELLENT) excellent++;
        if ((float) excellent/sum > LIMIT) {
            return true; //此处表示超过了优秀率限制
        }
        return false;
    }

    public double GetScore(Integer courseID,String studentID) {
        StudentCourse studentCourse = new StudentCourse();

        return studentCourse.GetStudentScore(studentID,courseID);
    }
}
