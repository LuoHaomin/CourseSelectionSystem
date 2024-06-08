package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.MajorCourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Database.CourseEditorImpl;
import cn.ustc.edu.course_selection_system.Database.DisciplinaryPlanData;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;
import cn.ustc.edu.course_selection_system.Util.CourseTable;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 获得所选课程
     * @return 课程列表
     */
    public List<CourseEntity> getRelatedCourse() {
        StudentCourse studentCourse = new StudentCourse();
        return studentCourse.GetChosenCourseList(id);
    }


    /**
     * 获得课程表数据
     */
    public CourseTable getCourseTable(){
        StudentCourse studentCourse = new StudentCourse();
        return new CourseTable(studentCourse.GetChosenCourseList(id));
    }

    /**
     * 获得培养方案（待选课程列表）
     * @return 待选课程编号列表
     */
    public List<String> getProgram(){
        DisciplinaryPlanData disciplinaryPlanData = new DisciplinaryPlanData();
        List<MajorCourseEntity> majorCourseEntityList = disciplinaryPlanData.GetDisciplinaryPlan(GetID().getMajor());
        List<String> program = new ArrayList<>();
        for(MajorCourseEntity majorCourseEntity : majorCourseEntityList){
            program.add(majorCourseEntity.getCourseNumber());
        }
        return program;
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
        //TODO:我需要courseId
//        if(courseEditor.GetNumberOfStudentsInCourse()>=courseEntity.getCapacity()){
//            return false;
//        }

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
    public List<Pair<String, Double>> getScore(){
        StudentCourse studentCourse = new StudentCourse();
        List<CourseEntity> courseList = studentCourse.GetChosenCourseList(id);
        List<Pair<String,Double>> score = new ArrayList<>();

        for(CourseEntity courseEntity : courseList){
            score.add(new Pair<>(courseEntity.getName(), studentCourse.GetStudentScore(id, courseEntity.getId())));
        }
        return score;
    }

    public float translateGPA (double score){
        if (score < 60) return 0.0f;
        else if (score == 60) return 1.0f;
        else if (score > 60 && score <64) return 1.3f;
        else if (score == 64) return 1.5f;
        else if (score > 64 && score < 68) return 1.7f;
        else if (score > 67 && score < 72) return 2.0f;
        else if (score > 71 && score < 75) return 2.3f;
        else if (score > 74 && score < 78) return 2.7f;
        else if (score > 77 && score < 82) return 3.0f;
        else if (score > 81 && score < 85) return 3.3f;
        else if (score > 84 && score < 90) return 3.7f;
        else if (score > 89 && score < 95) return 4.0f;
        else if (score > 94 && score <= 100) return 4.3f;
    }

    public double generalGPA () {
        StudentCourse studentCourse = new StudentCourse();
        double totalGPA = 0,totalCredit = 0,generalGPA = 0;
        List<CourseEntity> courseEntityList = studentCourse.GetChosenCourseList(id);
        for (CourseEntity course : courseEntityList) {
            totalGPA += course.getCredit()*studentCourse.GetStudentScore(id,course.getId());
            totalCredit += course.getCredit();
        }
        generalGPA = totalGPA/totalCredit;
        return generalGPA;
    }

}
