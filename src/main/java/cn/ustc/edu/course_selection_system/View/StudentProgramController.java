package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Service.PageJump;
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

public class StudentProgramController implements Page{
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
        PageJump.JumpTo("/cn/ustc/edu/course_selection_system/ChangCodeScene.fxml",id,(Stage)ChangeCode.getScene().getWindow());
    }
    @FXML
    private void HandleBack(ActionEvent event) throws IOException
    {
        PageJump.JumpTo("/cn/ustc/edu/course_selection_system/Loginscene.fxml",(Stage) Back.getScene().getWindow());
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

            PageJump.JumpTo("/cn/ustc/edu/course_selection_system/StudentHandleCourse.fxml",id,(Stage)Course.getScene().getWindow());
        }
    }
    @FXML
    public void HandleScore(ActionEvent event) throws IOException
    {
        if (Score.isSelected()){
            PageJump.JumpTo("/cn/ustc/edu/course_selection_system/StudentScore.fxml",id,(Stage)Score.getScene().getWindow());
        }
    }
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {}
    @FXML
    public void HandleCourseList(ActionEvent event) throws IOException
    {
        if(CourseList.isSelected())
        {
            PageJump.JumpTo("/cn/ustc/edu/course_selection_system/StudentCourseList.fxml",id,(Stage)Program.getScene().getWindow());
        }
    }
    public class tableline
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
                studentHandleCourseController.start(id);
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
        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Enter.setCellValueFactory(new PropertyValueFactory<>("BtEnter"));
        ObservableList<tableline> list= FXCollections.observableArrayList();
        for (String courseName : programlist) {
            list.add(new tableline(courseName));
        }
        table.setItems(list);
    }
}