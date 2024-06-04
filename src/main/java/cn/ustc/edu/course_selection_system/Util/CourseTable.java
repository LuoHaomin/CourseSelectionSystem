package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.List;

public class CourseTable {
    List<CourseEntity> list;
    public CourseTable(List<CourseEntity> courseList){
        list=courseList;
    }
    public Boolean IsConflicted(CourseEntity courseEntity){
        return false;
    }
}
