package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Period {

    public ArrayList<String> getWeek (CourseEntity courseEntity) {
        String Period = courseEntity.getPeriods();
        ArrayList<String> week = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(Period);
        while (matcher.find()) {
            week[Integer.parseInt(matcher.group())] = matcher.group();
        }
        if (Period.contains("O")) {
            ArrayList<String> oddweek = new ArrayList<String>();
            for (String i : week)
                if ((Integer.parseInt(i) % 2) == 1) {
                    oddweek.add(i);
                }
        } else if (Period.contains("E")) {
            ArrayList<String> evenweek = new ArrayList<String>();
            for (String j : evenweek) {
                if(Integer.parseInt(j) % 2 == 0) evenweek.add(j);
            }
        }
        return week;
    }
    public Boolean Coincide (CourseEntity courseEntity,CourseEntity courseEntity1) {
        ArrayList<String> period = getWeek(courseEntity);
        ArrayList<String> period1 = getWeek(courseEntity1);
        for (String i : period) {
            for (String j : period1) {
                if (i.equals(j)) {
                    return true;
                }
            }
        }
    return false;
    }
}
