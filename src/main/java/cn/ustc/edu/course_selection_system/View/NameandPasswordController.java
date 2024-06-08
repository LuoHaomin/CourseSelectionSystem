package cn.ustc.edu.course_selection_system.View;

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

public class NameandPasswordController {
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
            Pair<String,String> idname =passwordChecker.checkID(um,pw);

            if(idname.getValue() =="")//用户名不存在或用户名与密码不匹配
            {
                wronglabel.setVisible(true);
            }
            if(idname.getValue() == "admin")//该用户是管理员
            {

            }
            if(idname.getValue() =="teacher")//该用户是老师
            {
                FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherLogin.fxml"));
                Parent root=loader.load();
                TeacherLoginController teacherloginController=loader.getController();
                teacherloginController.start(idname.getKey());
                Stage stage=(Stage) login.getScene().getWindow();
                Scene scene=new Scene(root,600,400);
                stage.setScene(scene);
                stage.show();
            }
            if(idname.getValue() =="student")//该用户是学生
            {

            }
    }


}
