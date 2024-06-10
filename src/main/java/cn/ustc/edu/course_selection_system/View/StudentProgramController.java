package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StudentProgramController {
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
    private RadioButton Course;
    @FXML
    private RadioButton Score;
    @FXML
    private RadioButton CourseList;
    @FXML
    private RadioButton Program;
    @FXML
    public void HandleCourse(ActionEvent event) throws IOException
    {
        if(Course.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentHandleCourse.fxml"));
            Parent root=loader.load();
            StudentHandleCourseController studentHandleCourseController =loader.getController();
            studentHandleCourseController.start(id);
            Stage stage=(Stage) Course.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleScore(ActionEvent event) throws IOException
    {
        if(Score.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentScore.fxml"));
            Parent root=loader.load();
            StudentScoreController studentScoreController =loader.getController();
            studentScoreController.start(id);
            Stage stage=(Stage) Score.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {
    }
    @FXML
    public void HandleCourseList(ActionEvent event) throws IOException
    {
        if(CourseList.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentCourseList.fxml"));
            Parent root=loader.load();
            StudentCourseListController studentCourseListController =loader.getController();
            studentCourseListController.start(id);
            Stage stage=(Stage) Program.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    class tableline
    {
        String courseName;
        Button btEnter;
        public tableline(String courseName)
        {
            this.courseName=courseName;
            btEnter=new Button("搜索");
            btEnter.setOnAction(event -> {
                FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentHandleCourse.fxml"));
                Parent root;
                try {
                    root = loader.load();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                StudentHandleCourseController studentHandleCourseController =loader.getController();
                studentHandleCourseController.setQCourseName(courseName);
                studentHandleCourseController.HandleFind(new ActionEvent());
                Stage stage=(Stage) Course.getScene().getWindow();
                Scene scene=new Scene(root,600,400);
                stage.setScene(scene);
                stage.show();
            });
        }
        public String getCourseName() {
            return courseName;
        }
        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
        public Button getBtEnter() {
            return btEnter;
        }
        public void setBtEnter(Button btEnter) {
            this.btEnter = btEnter;
        }
    }
    @FXML
    TableView<tableline> table;
    @FXML
    TableColumn<tableline,String> CourseName;
    @FXML
    TableColumn<tableline,Button> Enter;
    public void start(String id) {
        this.id = id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        Name.setText(studentEntity.getName());
        List<String> programlist=studentService.getProgram();
        CourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        Enter.setCellValueFactory(new PropertyValueFactory<>("btEnter"));
        ObservableList<tableline> list= FXCollections.observableArrayList();
        table=new TableView<>(list);
        for(int i=0;i<programlist.size();i++)
        {
            String courseName=programlist.get(i);
            table.getItems().add(new tableline(courseName));
        }
    }
}