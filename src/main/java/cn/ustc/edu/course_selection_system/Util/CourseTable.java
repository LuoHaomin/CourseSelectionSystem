package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.Arrays;
import java.util.List;

import static cn.ustc.edu.course_selection_system.Util.Period.getWeek;

/**
 * 课程表（用于判断课程是否冲突
 ，以及获取当周时间段内课程表）
 */
public class CourseTable {

    List<CourseEntity> list;


    public CourseTable (List<CourseEntity> courseList) { list = courseList; }

    /**
     * 判断课程是否冲突
     * @param courseEntity 课程
     * @return 是否冲突
     */
    public Boolean IsConflict(CourseEntity courseEntity){
        for (CourseEntity course:list) {
            if ( ( Time.timeCoincide(course,courseEntity) )
                    && ( Period.periodCoincide(courseEntity,course) ) )  {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取当周时间段内课程表
     * @param time 时间
     * @param week 周
     * @return 课程表
     */
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
