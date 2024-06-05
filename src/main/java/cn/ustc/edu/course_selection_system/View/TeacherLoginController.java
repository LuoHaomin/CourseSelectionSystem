package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Service.TeacherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class TeacherLoginController {
    private String id;
    @FXML
    private Label Name;
    @FXML
    private Button ChangeCode;
    @FXML
    private Button Back;

    @FXML
    private void HandleChangeCode(ActionEvent event) throws IOException
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/ChangCodeScene.fxml"));
        Parent root=loader.load();
        ChangeCodeSceneController changeCodeSceneController=loader.getController();
        changeCodeSceneController.start(id);
        Stage stage=(Stage) ChangeCode.getScene().getWindow();
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
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
    private ListView<HBox> Course;
    @FXML
    private ListView<HBox> getin;

    public void start(String id)
    {
        this.id=id;
        TeacherService teacherService=new TeacherService(id);
        TeacherEntity teacherEntity=teacherService.GetID();
        Name.setText(teacherEntity.getName());
        List<CourseEntity> courselist=teacherService.getRelatedCourse();
        ObservableList<HBox> courseobser=FXCollections.observableArrayList();
        ObservableList<HBox> getinobser=FXCollections.observableArrayList();
        Course=new ListView<HBox>(courseobser);
        getin=new ListView<HBox>(getinobser);
        int size=courselist.size();
        for(int i=0;i<size;i++)
        {
            //加入课程名
            CourseEntity courseEntity=courselist.get(i);
            String coursename=courseEntity.getNumber();
            HBox hBox1=new HBox(10);
            hBox1.getChildren().add(new Label(coursename));
            courseobser.add(hBox1);
            //加入课程跳转按钮（根据id,传两个id，一个老师，一个课程)
            Button btgo=new Button("前往"+coursename);
            btgo.setOnAction(e -> {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherWelcome.fxml"));
                Parent root= null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                TeacherWelcomeController teacherWelcomeController =loader.getController();
                teacherWelcomeController.start(id,courseEntity.getId());
                Stage stage=(Stage) ChangeCode.getScene().getWindow();
                Scene scene=new Scene(root,600,400);
                stage.setScene(scene);
                stage.show();
                    }
            );
            HBox hbox2=new HBox(10);
            hbox2.getChildren().add(btgo);
            getinobser.add(hbox2);
        }
    }


}
