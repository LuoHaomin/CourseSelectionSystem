package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Service.PageJump;
import cn.ustc.edu.course_selection_system.Service.PasswordChecker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Objects;

import static cn.ustc.edu.course_selection_system.Service.PageJump.*;
import static cn.ustc.edu.course_selection_system.Service.PageJump.JumpTo;

public class NameAndPasswordController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Label wronglabel;

    @FXML
    private void HandleLoginAction(ActionEvent event) throws IOException
    {
            String um=username.getText();
            String pw=password.getText();
            PasswordChecker passwordChecker=new PasswordChecker();
            Pair<String,String> IdName =passwordChecker.checkID(um,pw);

            if(Objects.equals(IdName.getValue(), ""))//用户名不存在或用户名与密码不匹配
            {
                wronglabel.setVisible(true);
            }
            if(Objects.equals(IdName.getValue(), "admin"))//该用户是管理员
            {
                JumpTo("/cn/ustc/edu/course_selection_system/AdminRegisStudent.fxml",(Stage) login.getScene().getWindow());
            }
            if(Objects.equals(IdName.getValue(), "teacher"))//该用户是老师
            {
                JumpTo("/cn/ustc/edu/course_selection_system/TeacherLogin.fxml", IdName.getKey(), (Stage) login.getScene().getWindow());
            }
            if(Objects.equals(IdName.getValue(), "student"))//该用户是学生
            {
                JumpTo("/cn/ustc/edu/course_selection_system/StudentCourseList.fxml", IdName.getKey(), (Stage) login.getScene().getWindow());
            }
    }



}
