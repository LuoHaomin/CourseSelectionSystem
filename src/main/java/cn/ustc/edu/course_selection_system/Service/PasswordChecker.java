package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.AdminEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.AdminImpl;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;
import javafx.util.Pair;

public class PasswordChecker {
    /**
     * 检查账号与密码，若成功返回id号与身份，失败则抛出异常，并返回身份“”（空串）。
     * @param account 账号（默认用id）
     * @param password 密码
     * @return ID号，身份（"student"/"teacher"/"admin"）
     */
    public Pair<String,String> checkID(String account,String password){
        if (account == null || account.isEmpty() || password == null || password.isEmpty()){
            return new Pair<>("","");
        }

        if(account.contains("ST")){
            try {
                StudentImpl studentImpl = new StudentImpl();
                StudentEntity studentEntity = studentImpl.getStudent(account);
                if(studentEntity == null){
                    return new Pair<>("","");
                }
                else {
                    if(studentEntity.getPassword().equals(password)){
                        return new Pair<>(studentEntity.getId(),"student");
                    }
                }
            }
            catch (Exception ignored){
                //ToDo:
                return new Pair<>("","");
            }
        }
        else if(account.contains("TC")){
            TeacherImpl teacherImpl = new TeacherImpl();
            TeacherEntity teacherEntity = teacherImpl.getTeacher(account);
            if(teacherEntity == null){
                return new Pair<>("","");
            }
            else {
                if(teacherImpl.getTeacher(account).getPassword().equals(password)){
                    return new Pair<>(teacherEntity.getId(),"teacher");
                }
            }
        }
        else {
            try {
                int adminID = Integer.parseInt(account);
                AdminImpl adminImpl = new AdminImpl();
                if(adminImpl.getAdmin(adminID) == null){
                    return new Pair<>("","");
                }
                else {
                    if(adminImpl.getAdmin(adminID).getPassword().equals(password)){
                        return new Pair<>(account,"admin");
                    }
                }

            }
            catch (Exception ignored){}
        }
        return new Pair<>("","");
    }
}
