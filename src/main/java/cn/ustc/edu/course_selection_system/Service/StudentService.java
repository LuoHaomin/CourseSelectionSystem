package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentInfo;
import cn.ustc.edu.course_selection_system.Database.ID_Editor;
import cn.ustc.edu.course_selection_system.Database.ID_EditorImpl;

import java.util.List;

public class StudentService extends AbstractStudentService{
    @Override
    public StudentInfo GetID() {
        ID_Editor idEditor = new ID_EditorImpl();
        return (StudentInfo) idEditor.GetID(this.id);
    }

    @Override
    public List<String> GetSchedule() {
        return List.of();
    }
}
