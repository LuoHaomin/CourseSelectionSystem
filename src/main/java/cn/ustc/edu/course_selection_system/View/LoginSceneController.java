package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Service.PageJump;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {
    @FXML
    private Button Login;

    @FXML
    private void HandleLoginAction(ActionEvent event) throws IOException
    {
        PageJump.JumpTo("/cn/ustc/edu/course_selection_system/NameandPassword.fxml",(Stage) Login.getScene().getWindow());
    }

}
