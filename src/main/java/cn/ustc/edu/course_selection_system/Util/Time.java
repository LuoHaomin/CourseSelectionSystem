package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    public static String detailDay (CourseEntity course) {
        String time = course.getTime();
        Pattern pattern = Pattern.compile("[a-zA-Z]+]");
        Matcher matcher = pattern.matcher(time);
        if (matcher.find()) {
            return matcher.group();
        }
    }
    public static ArrayList<String> detailTime (CourseEntity course) {
        String time = course.getTime();
        ArrayList<String> timeArray = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(time);
        while (matcher.find()) {
            timeArray.add(matcher.group());
        }
        return timeArray;
    }
    public static Boolean timeCoincide (CourseEntity course,CourseEntity courseEntity) {
        if (detailDay(course).equals(detailDay(courseEntity))) {
            for (String time : detailTime(course))
                for (String time1 : detailTime(courseEntity))
                    if (time.equals(time1)) return true;
        }
        return false;
    }
}
