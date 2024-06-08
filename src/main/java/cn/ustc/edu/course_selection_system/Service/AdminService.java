package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.*;
import cn.ustc.edu.course_selection_system.Database.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    /**
     * 批量导入学生信息
     * @param infos 信息列表
     * @return 成功导入人数
     */

    public int ImportStudentID(List<StudentEntity> infos){
        StudentImpl studentImpl = new StudentImpl();
        for(StudentEntity info : infos){
            studentImpl.addStudent(info);
        }
        return infos.size();
    }

    /**
     * 批量导入教师信息
     * @param infos 教师信息
     * @return 成功导入人数
     */
    public int ImportTeacherID(List<TeacherEntity> infos){
        TeacherImpl teacherImpl = new TeacherImpl();
        for(TeacherEntity info : infos){
            teacherImpl.addTeacher(info);
        }
        return infos.size();
    }
    /**
     * 批量导入课程信息
     * @param courseInfos 课程信息
     * @return 成功导入个数
     */
	public int ImportCourse(List<CourseEntity> courseInfos) {
        CourseEditorImpl courseEditorImpl = new CourseEditorImpl();
        for(CourseEntity info : courseInfos){
            courseEditorImpl.AddCourse(info);
        }
        return courseInfos.size();
    }


    /**
     * 导入学生-课程对
     * @param S_CList 学生-课程列表
     * @return 成功导入个数
     */
    public int ImportS_C(List<Pair<String,Integer>> S_CList){
        StudentCourse studentCourse = new StudentCourse();
        for(Pair<String,Integer> info : S_CList){
            studentCourse.AddCoursePair(info.getKey(), info.getValue());
        }
        return 0;
    }

    /**
     * 导入教师-课程对
     * @param T_CList 教师-课程列表
     * @return 成功导入个数
     */
    public int ImportT_C(List<Pair<String,Integer>> T_CList){
        TeacherCourse teacherCourse = new TeacherCourse();
        for(Pair<String,Integer> info : T_CList){
            teacherCourse.AddCoursePair(info.getKey(),info.getValue());
        }
        return 0;
    }

    /**
     * 删除人员（包括关联键）
     * @param id_list 删除人员id名单
     * @return 成功删除个数
     */
    public int DelID(List<String> id_list){

        return 0;
    }

    /**
     * 删除课程（包括关联键）
     * @param id_list  删除课程id名单
     * @return 成功删除个数
     */
	public int DelCourse(List<Integer> id_list){
        return 0;
    }

    /**
     * 删除学生-课程对
     * @param S_CList 学生-课程对
     * @return 成功删除个数
     */
	public int DelS_C(Pair<Integer,Integer> S_CList){
        return 0;
    }

    /**
     * 删除教师-课程对
     * @param T_CList 教师-课程对
     * @return 成功删除个数
     */
    public int DelT_C(Pair<Integer,Integer> T_CList){
        return 0;
    }

    public List<CourseInfo>  getCourseInfoList(Integer page,Integer ItemsPerPage){
        return null;
    }

    /**
     * 获得课程完整信息
     * @return 课程完整信息
     */
    public List<CourseInfo>  getCourseInfoList(){
        TeacherCourse teacherCourse = new TeacherCourse();
        CourseEditorImpl courseEditorImpl = new CourseEditorImpl();
        TeacherImpl teacherImpl = new TeacherImpl();
        List<TeacherCourseEntity> list =teacherCourse.GetTeachingCourseAllList();

        List<CourseInfo> courseInfos = new ArrayList<>();


        for(TeacherCourseEntity info : list){
            CourseInfo courseInfo = new CourseInfo(courseEditorImpl.GetCourseInfo(info.getCourseId()), teacherImpl.getTeacher(info.getTeacherId()));
            courseInfos.add(courseInfo);
        }
        return courseInfos;
    }
}
