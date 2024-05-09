package cn.ustc.edu.course_selection_system.Database;

public interface PasswordChecker {
    boolean isPasswordCorrect(int id,String password);
}
