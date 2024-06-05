package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.List;
import cn.ustc.edu.course_selection_system.Util.Period.*;

public class CourseTable {

    List<CourseEntity> list;

    public CourseTable (List<CourseEntity> courseList) { list = courseList; }


    /**
     * 判断输入是否与已有课程重叠
     * @param courseEntity 待判断课程
     * @return 是否重叠
     */
    public Boolean IsConflicted(CourseEntity courseEntity){
        for (CourseEntity course:list) {
            if ( (course.getTime().equals(courseEntity.getTime())
                    && (course.getPeriods().Coincide(courseEntity.getPeriods()))) ) {
                return true;
            }
        }
        return false;
    }

   // public Boolean

    public List<CourseEntity> DayCourse (String day) {
        List<CourseEntity> dayCourse = new ArrayList<>();
        for (CourseEntity course:list)  {
            if (course.getTime().contains(day)) {
                dayCourse.add(course);
            }
        }
        return dayCourse;
    }


}
