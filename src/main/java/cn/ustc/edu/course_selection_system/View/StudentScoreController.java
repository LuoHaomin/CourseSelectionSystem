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
import javafx.util.Pair;

import java.io.IOException;
import java.util.List;

public class StudentScoreController {
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
    {}
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {
        if(Program.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentProgram.fxml"));
            Parent root=loader.load();
            StudentProgramController studentProgramController =loader.getController();
            studentProgramController.start(id);
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

    /**
     * 内部类——TableView的行
     * 第一列显示课程名称，第二列显示课程分数，第三列显示课程绩点
     */
    public class tableline
    {
        String coursename;
        Double score;
        Double gpa;
        public tableline(String coursename, Double score, Double gpa)
        {
            this.coursename=coursename;
            this.score=score;
            this.gpa=gpa;
        }
        public Double getGpa() {return gpa;}
        public void setGpa(Double gpa) {this.gpa = gpa;}
        public Double getScore() {return score;}
        public void setScore(Double score) {this.score = score;}
        public String getCourseName() {return coursename;}
        public void setCoursename(String coursename) {this.coursename = coursename;}
    }
    @FXML
    private Label Agpa;
    @FXML
    private TableView<tableline> table;
    @FXML
    private TableColumn<tableline,String> CourseName;
    @FXML
    private TableColumn<tableline,Double> TScore;
    @FXML
    private TableColumn<tableline,Double> GPA;
    public void start(String id)
    {
        this.id = id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        Name.setText(studentEntity.getName());

        List<Pair<String,Double>> scorelist=studentService.getScore();//得到课程-成绩对列表
        Agpa.setText(Double.toString(studentService.averageGPA()));//显示学生的总体GPA

        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        TScore.setCellValueFactory(new PropertyValueFactory<>("Score"));
        GPA.setCellValueFactory(new PropertyValueFactory<>("Gpa"));

        ObservableList<tableline> list=FXCollections.observableArrayList();
        for(Pair<String,Double> thisscore:scorelist){
            double thisgpa=studentService.translateGPA(thisscore.getValue());
            list.add(new tableline(thisscore.getKey(),thisscore.getValue(),thisgpa));
        }
        table.setItems(list);
    }
}
