package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.List;
import cn.ustc.edu.course_selection_system.Util.Period.*;

public class CourseTable {

    List<CourseEntity> list;

    public CourseTable (List<CourseEntity> courseList) { list = courseList; }

    public Boolean IsConflicted(CourseEntity courseEntity){
        for (CourseEntity course:list) {
            if ( (course.getTime().equals(courseEntity.getTime())
                    && (Period.periodCoincide(courseEntity,course))) ) {
                return true;
            }
        }
        return false;
    }


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
