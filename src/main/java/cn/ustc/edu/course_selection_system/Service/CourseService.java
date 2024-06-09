package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Database.CourseImpl;
import cn.ustc.edu.course_selection_system.Database.StudentCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherCourse;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    /**
     * 课程id
     */
    int id;

    public CourseService(int id) {
        this.id = id;
    }


    /**
     * 获得课程中的学生id列表
     * @return id列表
     */
    public List<String> GetStudentInCourse(){
        StudentCourse studentCourse = new StudentCourse();
        return studentCourse.GetStudentList(id);
    }

    /**
     * 获得课程信息
     * @return 课程信息
     */
    public CourseEntity GetCourseInfo(){
        CourseImpl courseEditor = new CourseImpl();
        return courseEditor.GetCourseInfo(id);
    }

    public Integer GetNumberOfStudentsInCourse(){
        CourseImpl courseEditor = new CourseImpl();
        return courseEditor.GetNumberOfStudentsInCourse(id);
    }

    public static List<CourseInfo>  getCourseInfoList(Integer page, Integer Limit){
        TeacherCourse teacherCourse = new TeacherCourse();
        CourseImpl courseEditorImpl = new CourseImpl();
        TeacherImpl teacherImpl = new TeacherImpl();

        List<CourseEntity> Course = courseEditorImpl.getAllCourses(page, Limit);
        return getCourseInfos(Course, teacherCourse);
    }


    public static int getNumberOfCourses(){
        CourseImpl courseEditorImpl = new CourseImpl();
        return courseEditorImpl.getNumberOfCourses();
    }

    /**
     * 获得课程完整信息
     * @return 课程完整信息
     */
    public static List<CourseInfo>  getCourseInfoList(){
        TeacherCourse teacherCourse = new TeacherCourse();
        CourseImpl courseEditorImpl = new CourseImpl();

        List<CourseEntity> Course = courseEditorImpl.getAllCourses();

        return getCourseInfos(Course, teacherCourse);
    }

    private static List<CourseInfo> getCourseInfos(List<CourseEntity> Course, TeacherCourse teacherCourse) {
        List<CourseInfo> courseInfos = new ArrayList<>();
        for(CourseEntity info : Course){
            CourseInfo courseInfo = new CourseInfo(info, teacherCourse.GetTeachersOfCourse(info.getId()));
            courseInfos.add(courseInfo);
        }
        return courseInfos;
    }

    public static Integer GetNumberOfCourseInfoByName(String courseName){
        CourseImpl courseEditorImpl = new CourseImpl();
        return null;
        //TODO:
    }
    public List<CourseInfo> GetCourseInfoByName(String courseName){
        CourseImpl courseEditorImpl = new CourseImpl();
        return getCourseInfos(courseEditorImpl.FindByCourseName(courseName),new TeacherCourse());
    }

    public List<CourseInfo> GetCourseInfoByName(String courseName,Integer page,Integer Limit){
        CourseImpl courseEditorImpl = new CourseImpl();
        return getCourseInfos(courseEditorImpl.FindByCourseName(courseName),new TeacherCourse());
    }
}
