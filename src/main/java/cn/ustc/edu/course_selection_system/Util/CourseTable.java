package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
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


    public String[] TimeCourse (String time,String week) {
        String[] timeCourse = new String[7];
        for (CourseEntity course:list)  {
            for (Day day : Day.values()) {
                if (Period.periodInclude(week,getWeek(course))
                        && Time.timeInclude(time,Time.detailTime(course))) {
                    if (course.getTime().contains("Mon"))
                        timeCourse[0] = course.getName();
                    else timeCourse[0] = "";
                    if (course.getTime().contains("Tue"))
                        timeCourse[1] = course.getName();
                    else timeCourse[1] = "";
                    if (course.getTime().contains("Wed"))
                        timeCourse[2] = course.getName();
                    else timeCourse[2] = "";
                    if (course.getTime().contains("Thu"))
                        timeCourse[3] = course.getName();
                    else timeCourse[2] = "";
                    if (course.getTime().contains("Fri"))
                        timeCourse[4] = course.getName();
                    else timeCourse[4] = "";
                    if (course.getTime().contains("Sat"))
                        timeCourse[5] = course.getName();
                    else timeCourse[5] = "";
                    if (course.getTime().contains("Sun"))
                        timeCourse[6] = course.getName();
                    else timeCourse[6] = "";
                }
            }
        }
        return timeCourse;
    }


}
