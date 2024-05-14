package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentInfo;

import java.util.List;

public abstract class AbstractStudentService {
    int id;
    public abstract StudentInfo GetID();
    public abstract List<String> GetSchedule();

}
