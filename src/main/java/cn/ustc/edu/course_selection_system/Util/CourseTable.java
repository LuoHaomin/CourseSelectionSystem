package cn.ustc.edu.course_selection_system.Util;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;

import java.util.List;

public class CourseTable {
    List<CourseEntity> list;


    public CourseTable(List<CourseEntity> courseList){
        list=courseList;
    }

    /**
     * 判断输入是否与已有课程重叠
     * @param courseEntity 待判断课程
     * @return 是否重叠
     */
    public Boolean IsConflicted(CourseEntity courseEntity){
        return false;
    }


}
