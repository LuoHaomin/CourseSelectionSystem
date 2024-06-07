package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Database.PasswordCheckerImpl;
import cn.ustc.edu.course_selection_system.Service.PasswordChecker;
import org.junit.jupiter.api.Test;

public class PassWordCheckerTest {
    @Test
    public void testIsPasswordCorrect() {
        PasswordCheckerImpl passwordChecker = new PasswordCheckerImpl();
        System.out.println(passwordChecker.isPasswordCorrect("2019211001", "123456"));
        System.out.println(passwordChecker.isPasswordCorrect("2019211002", "123456"));
        System.out.println(passwordChecker.isPasswordCorrect("2019211003", "123456"));
    }
}
