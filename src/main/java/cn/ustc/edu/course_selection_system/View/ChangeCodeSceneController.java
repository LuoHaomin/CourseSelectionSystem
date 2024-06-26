package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Service.PasswordChecker;
import cn.ustc.edu.course_selection_system.Service.StudentService;
import cn.ustc.edu.course_selection_system.Service.TeacherService;
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

public class ChangeCodeSceneController {
    private String id;
    @FXML
    private TextField Name;
    @FXML
    private TextField OldCode;
    @FXML
    private PasswordField NewCode1;
    @FXML
    private PasswordField NewCode2;
    @FXML
    private Button Sure;
    @FXML
    private Button Back;
    @FXML
    private Label Wrong;

    public void start(String id)
    {
        this.id=id;
    }
    @FXML
    private void HandleBack(ActionEvent event) throws IOException
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/Loginscene.fxml"));
        Parent root=loader.load();
        Stage stage=(Stage) Back.getScene().getWindow();
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void HandleSure(ActionEvent event) throws IOException
    {
        String nm=Name.getText();
        String oc=OldCode.getText();
        String nc1=NewCode1.getText();
        String nc2=NewCode2.getText();
        PasswordChecker passwordChecker=new PasswordChecker();
        Pair<String,String> idname=passwordChecker.checkID(nm,oc);
        if(!idname.getValue().isEmpty() && Objects.equals(nc1, nc2)) {
            if(idname.getValue()=="student")//学生更改密码
            {
                StudentService studentService=new StudentService(idname.getKey());
                StudentEntity studentEntity=studentService.GetID();
                studentEntity.setPassword(nc1);
                studentService.updateID(studentEntity);
            }
            if(idname.getValue()=="teacher")//教师更改密码
            {
                TeacherService teacherService=new TeacherService(idname.getKey());
                TeacherEntity teacherEntity=teacherService.GetID();
                teacherEntity.setPassword(nc1);
                teacherService.updateID(teacherEntity);
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/NameandPassword.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) Sure.getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Wrong.setVisible(true);//如果用户名与旧密码不匹配或者新输入的两个密码不匹配，则返回错误信息
        }
    }

}
