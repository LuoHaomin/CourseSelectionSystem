package cn.ustc.edu.course_selection_system.Util;

public class ID {
    static Position getPosition(String id) {
        if(id.contains("ST")){
            return Position.Student;
        }
        if(id.contains("TC")){
            return Position.Teacher;
        }
        try {
            Integer.parseInt(id);
            return Position.Admin;
        }
        catch(Exception exception) {
            return null;
        }
    }
}

