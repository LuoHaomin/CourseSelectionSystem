package cn.ustc.edu.course_selection_system.Bean;

public class CourseInfo {

    int id;
    /**
     * 课程编码（每种科目对应唯一编码）
     */
    int code;

    String name;
    String teacher;
    /**
     * 课程时间（如周六（1，2，3））
     */
    String time;

    /**
     * 课程起始周数（如2-4（单））
     */
    String period;
    //Todo：怎么表示更好？

    /**
     * 学分
     */
    int credit;
}
