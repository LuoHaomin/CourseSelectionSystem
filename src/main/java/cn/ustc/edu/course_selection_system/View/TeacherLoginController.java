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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    /**
     * 内部类——TableView的行
     * 第一列显示课程名称，第二列显示进入课程按钮
     */
    public class tableline
    {
        String coursename;
        Button btgo;
        public tableline(CourseEntity courseEntity)
        {
            coursename=courseEntity.getName();

            btgo=new Button("前往"+coursename);
            btgo.setOnAction(e -> {
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherWelcome.fxml"));
                        Parent root;
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
        }
        public String getCourseName() {return coursename;}
        public Button getBtgo() {return btgo;}
        public void setCourseName(String coursename) {this.coursename = coursename;}
        public void setBtgo(Button btgo) {this.btgo = btgo;}
    }

    @FXML
    private TableView<tableline> Table;
    @FXML
    private TableColumn<tableline,String> CourseName;
    @FXML
    private TableColumn<tableline,Button> Login;
    public void start(String id)//入口，设置界面
    {
        this.id=id;
        TeacherService teacherService=new TeacherService(id);
        TeacherEntity teacherEntity=teacherService.GetID();
        Name.setText(teacherEntity.getName());

        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Login.setCellValueFactory(new PropertyValueFactory<>("Btgo"));

        List<CourseEntity> courselist=teacherService.getRelatedCourse();//该老师全部课程列表

        ObservableList<tableline> list=FXCollections.observableArrayList();
        for (CourseEntity courseEntity : courselist) {
            //加入课程名//加入课程跳转按钮（根据id,传两个id，一个老师，一个课程)
            list.add(new tableline(courseEntity));
        }
        Table.setItems(list);
    }
}
