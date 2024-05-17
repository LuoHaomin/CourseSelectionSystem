package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.StudentInfo;
import cn.ustc.edu.course_selection_system.Database.PersonalInfoEditor;
import cn.ustc.edu.course_selection_system.Database.PersonalInfoEditorImpl;

import java.util.List;

public class StudentService extends AbstractStudentService{

    public StudentService(int id){
        this.id = id;
    }
    @Override
    public StudentInfo GetID() {
        PersonalInfoEditorImpl idEditor = new PersonalInfoEditorImpl();
        return (StudentInfo) idEditor.GetPersonalInfo(this.id);
    }

    @Override
    public List<String> GetSchedule() {
        return List.of();
    }
}
