package cn.ustc.edu.course_selection_system.tests;

import cn.ustc.edu.course_selection_system.Database.AdminImpl;
import org.junit.jupiter.api.Test;

public class AdminTest {
    @Test
    public void testAddAdmin() {
        AdminImpl adminImpl = new AdminImpl();
        adminImpl.addAdmin("123456");
        adminImpl.addAdmin("982612");
    }

    @Test
    public void testGetAdmin() {
        AdminImpl adminImpl = new AdminImpl();
        System.out.println(adminImpl.getAdmin(1).toString());
    }
}
