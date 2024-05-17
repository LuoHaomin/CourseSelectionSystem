package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentInfo;

import java.util.List;

/**
 * 学生相关服务
 */
public abstract class AbstractStudentService {
    int id;

    /**
     * 获取该学生的信息
     * @return 学生信息
     */
    public abstract StudentInfo GetID();

    /**
     * 获取课程表
     * @return 课程表数据
     */
    public abstract List<String> GetSchedule();

}
