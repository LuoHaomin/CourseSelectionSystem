package cn.ustc.edu.course_selection_system.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginsceneController {
    @FXML
    private Button Login;

    @FXML
    private void HandleLoginAction(ActionEvent event) throws IOException
    {
        FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/NameandPassword.fxml"));
        Parent root=loader.load();
        NameandPasswordController nameandPasswordController=loader.getController();
        Stage stage=(Stage) Login.getScene().getWindow();
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
}
