package cn.ustc.edu.course_selection_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Test extends Application{



    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(cn.ustc.edu.course_selection_system.HelloApplication.class.getResource("AdminCourseList.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(cn.ustc.edu.course_selection_system.HelloApplication.class.getResource("AdminRegisCourse.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(cn.ustc.edu.course_selection_system.HelloApplication.class.getResource("AdminRegisStudent.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(cn.ustc.edu.course_selection_system.HelloApplication.class.getResource("AdminIndivisualList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("教务选课系统");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
