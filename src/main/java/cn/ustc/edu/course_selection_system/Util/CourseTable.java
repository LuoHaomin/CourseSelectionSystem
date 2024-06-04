package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.List;

public class CourseTable {
    public CourseTable(List<CourseEntity> courseList){}
    public Boolean IsConflicted(CourseEntity courseEntity){
        return false;
    }
}
