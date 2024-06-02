package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import javafx.util.Pair;

import java.util.List;

public class CourseService {
    /**
     * 课程id
     */
    int id;

    /**
     * 获得课程中的学生id列表
     * @return id列表
     */
    public List<Integer> GetStudentInCourse(){
        return List.of();
    }

    /**
     * 获得课程信息
     * @return 课程信息
     */
    public CourseEntity GetCourseInfo(){
        return null;
    }

//    /**
//     * 批量导入学生成绩
//     * @param StudentList id-成绩
//     * @return 成功导出人数
//     */
//    public int ImportStudentScore(List<Pair<Integer,Integer>> StudentList){
//        return 0;
//    }
}
