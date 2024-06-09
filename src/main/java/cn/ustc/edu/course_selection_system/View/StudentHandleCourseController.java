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

public class StudentHandleCourseController {
    private String id;
    private int PageSize=12;
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
    {}
    @FXML
    public void HandleScore(ActionEvent event) throws IOException
    {
        if(Score.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentScore.fxml"));
            Parent root=loader.load();
            StudentScoreController studentScoreController =loader.getController();
//            studentScoreController.start(id);
            Stage stage=(Stage) Score.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {
        if(Program.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentProgram.fxml"));
            Parent root=loader.load();
            StudentProgramController studentProgramController =loader.getController();
//            studentProgramController.start(id);
            Stage stage=(Stage) Program.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
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
    @FXML
    TextField Symbol;
    class tableline
    {
        String CourseName;
        String Time;
        String Teacher;
        String Credit;
        String Period;
        String Capacity;
        Button Conduct;
        public tableline(String CourseName, String Time, String Teacher, String Credit, String Period, String Capacity,String StudentID,int CourseID,boolean selectordrop) {
            this.CourseName = CourseName;
            this.Time = Time;
            this.Teacher = Teacher;
            this.Credit = Credit;
            this.Period = Period;
            this.Capacity = Capacity;
            StudentService studentService=new StudentService(StudentID);
            if (selectordrop)
            {
                Conduct=new Button("选课");
                Conduct.setOnAction(event -> {
                    if(!studentService.chooseCourse(CourseID))
                    {
                        Symbol.setText("选课未成功");
                    }
                    else {
                        setTable(id);
                    }
                });
            }
            else{
                Conduct=new Button("退课");
                Conduct.setOnAction(event -> {
                    if(!studentService.dropCourse(CourseID))
                    {
                        Symbol.setText("退课未成功");
                    }
                    else {
                        setTable(id);
                    }
                });
            }
        }

    }
    @FXML
    private TableView<tableline> Table;
    @FXML
    private Pagination Paging;
    @FXML
    private TableColumn<tableline,String> CourseName;
    @FXML
    private TableColumn<tableline,String> Time;
    @FXML
    private TableColumn<tableline,String> Teacher;
    @FXML
    private TableColumn<tableline,String> Credit;
    @FXML
    private TableColumn<tableline,String> Period;
    @FXML
    private TableColumn<tableline,String> Capacity;
    @FXML
    private TableColumn<tableline,Button> Conduct;
    public void start(String id)
    {
        this.id = id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        Name.setText(studentEntity.getName());
        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        Credit.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        Conduct.setCellValueFactory(new PropertyValueFactory<>("Conduct"));
        setTable(id);
    }
    public void setTable(String id)
    {
        ObservableList<tableline> list= FXCollections.observableArrayList();
        StudentService studentService=new StudentService(id);

    }
}
