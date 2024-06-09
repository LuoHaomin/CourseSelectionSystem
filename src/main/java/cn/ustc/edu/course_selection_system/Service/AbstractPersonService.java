package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;

import java.util.List;

/**
 * 学生相关服务
 */
@Deprecated
public abstract class AbstractPersonService {
    String id;

    /**
     * 获取该学生的信息
     * @return 学生信息
     */
    public abstract StudentEntity GetID();

    /**
     * 获取相关课程
     * @return 课程编号
     */
    public abstract List<Integer> getRelatedCourses();

}
