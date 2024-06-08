package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.List;
import cn.ustc.edu.course_selection_system.Util.Period.*;
import cn.ustc.edu.course_selection_system.Util.Time.*;
import javafx.util.Pair;

public class CourseTable {

    List<CourseEntity> list;

    public CourseTable (List<CourseEntity> courseList) { list = courseList; }

    public Boolean IsConflicted(CourseEntity courseEntity){
        for (CourseEntity course:list) {
            if ( ( Time.timeCoincide(course,courseEntity) )
                    && ( Period.periodCoincide(courseEntity,course) ) )  {
                return true;
            }
        }
        return false;
    }


    public List<String> TimeCourse (String time) {
        List<String> dayCourse = new ArrayList<>();
        for (CourseEntity course:list)  {
            for (Day day : Day.values()) {
                if (course.getTime().contains(time)) {
                    if (course.getTime().contains("Mon"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Tue"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Wed"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Thr"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Fri"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Sar"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                    if (course.getTime().contains("Sun"))
                        dayCourse.add(course.getName());
                    else dayCourse.add("");
                }
            }
        }
        return dayCourse;
    }


}
