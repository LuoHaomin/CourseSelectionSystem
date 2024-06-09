package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import cn.ustc.edu.course_selection_system.Util.Period.*;
import cn.ustc.edu.course_selection_system.Util.Time.*;
import javafx.util.Pair;

import static cn.ustc.edu.course_selection_system.Util.Period.getWeek;

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

    public List<String> TimeCourse (String time,String week) {
        String[] timeCourse = new String[7];
        int i = 0;
        for (Day day : Day.values())  {
            for (CourseEntity course:list)  {
                if (Period.periodInclude(week,getWeek(course))
                        && Time.timeInclude(time,Time.detailTime(course))) {
                    if (Time.detailDay(course).equals(day.toString())) {
                        timeCourse[i] = course.getName();
                        break;
                    }
                    else timeCourse[i] = "";
                }
            }
            i++;
        }
        List<String> timecourse = Arrays.asList(timeCourse);
        return timecourse;
    }

}
