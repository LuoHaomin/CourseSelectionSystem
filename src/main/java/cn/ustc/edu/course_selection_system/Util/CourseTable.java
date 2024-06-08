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


    public String[] TimeCourse (String time,String period) {
        String[] dayCourse = new String[7];
        for (CourseEntity course:list)  {
            for (Day day : Day.values()) {
                if (Period.periodInclude(period,getWeek(course))
                        && Time.timeInclude(time,Time.detailTime(course))) {
                    if (course.getTime().contains("Mon"))
                        dayCourse[0] = course.getName();
                    else dayCourse[0] = "";
                    if (course.getTime().contains("Tue"))
                        dayCourse[1] = course.getName();
                    else dayCourse[1] = "";
                    if (course.getTime().contains("Wed"))
                        dayCourse[2] = course.getName();
                    else dayCourse[2] = "";
                    if (course.getTime().contains("Thr"))
                        dayCourse[3] = course.getName();
                    else dayCourse[2] = "";
                    if (course.getTime().contains("Fri"))
                        dayCourse[4] = course.getName();
                    else dayCourse[4] = "";
                    if (course.getTime().contains("Sar"))
                        dayCourse[5] = course.getName();
                    else dayCourse[5] = "";
                    if (course.getTime().contains("Sun"))
                        dayCourse[6] = course.getName();
                    else dayCourse[6] = "";
                }
            }
        }
        return dayCourse;
    }


}
