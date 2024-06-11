package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.View.Page;
import cn.ustc.edu.course_selection_system.View.TeacherLoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

public class PageJump {
    public static void JumpTo(String name, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(cn.ustc.edu.course_selection_system.HelloApplication.class.getResource(name));
        Parent root=loader.load();
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
    public static void JumpTo(String name,  String Id, Stage stage) throws IOException {
        FXMLLoader loader=new FXMLLoader(PageJump.class.getResource(name));
        Parent root=loader.load();
        Page controller=loader.getController();
        controller.start(Id);

        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
}
