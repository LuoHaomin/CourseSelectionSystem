package cn.ustc.edu.course_selection_system.View;

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

import java.io.IOException;

public class ChangeCodeSceneController {
    private int id=0;
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

    public void start(int id)
    {
        this.id=id;
//        Name.setText(GetName(id));
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
//        if(isPerson(nm,oc)!=0&&nc1==nc2) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/NameandPassword.fxml"));
//            Parent root = loader.load();
//            Stage stage = (Stage) Sure.getScene().getWindow();
//            Scene scene = new Scene(root, 600, 400);
//            stage.setScene(scene);
//            stage.show();
//        }
//        else
//        {
            Wrong.setVisible(true);
//        }
    }

}
