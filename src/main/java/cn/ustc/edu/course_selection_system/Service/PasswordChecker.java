package cn.ustc.edu.course_selection_system.Service;

import javafx.util.Pair;

public class PasswordChecker {
    /**
     * 检查账号与密码，若成功返回id号与身份，失败则抛出异常，并返回身份“”（空串）。
     * @param account 账号（默认用id）
     * @param password 密码
     * @return ID号，身份（"student"/"teacher"/"admin"）
     */
    public Pair<Integer,String> checkID(String account,String password){

        return new Pair<>(0,"stu");
    }
}
