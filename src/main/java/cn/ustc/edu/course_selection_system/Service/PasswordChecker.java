package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Database.AbstractPersonData;
import cn.ustc.edu.course_selection_system.Database.AdminImpl;
import cn.ustc.edu.course_selection_system.Database.StudentImpl;
import cn.ustc.edu.course_selection_system.Database.TeacherImpl;
import cn.ustc.edu.course_selection_system.Util.ID;
import cn.ustc.edu.course_selection_system.Util.Position;
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
        Position position = ID.getPosition(account);
        if (position ==null)
            return new Pair<>("","");

        if (position==Position.Admin){
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

        try {
            AbstractPersonData studentImpl =position==Position.Student? new StudentImpl(): new TeacherImpl();
            PersonInfo personInfo = studentImpl.getPersonInfo(account);
            if(personInfo==null){
                return new Pair<>("","");
            }
            else {
                if(personInfo.getPassword().equals(password)){
                    return new Pair<>(account,position==Position.Student?"student":"teacher");
                }
            }
        }
        catch (Exception ignored){

            return new Pair<>("","");
        }


        return new Pair<>("","");
    }
}
