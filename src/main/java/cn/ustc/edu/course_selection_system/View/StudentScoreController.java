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
import javafx.util.Pair;

import java.io.IOException;
import java.util.List;

public class StudentScoreController implements Page{
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
    {}
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {
        if(Program.isSelected())
        {
            PageJump.JumpTo("/cn/ustc/edu/course_selection_system/StudentProgram.fxml",id,(Stage)Course.getScene().getWindow());
        }
    }
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
        String coursename;
        Double score;
        Double gpa;
        public tableline(String coursename, Double score, Double gpa)
        {
            this.coursename=coursename;
            this.score=score;
            this.gpa=gpa;
        }
        public Double getGpa()
        {
            return gpa;
        }
        public void setgpa(Double gpa)
        {
            this.gpa = gpa;
        }
        public Double getScore()
        {
            return score;
        }
        public void setscore(Double score)
        {
            this.score = score;
        }
        public String getCourseName()
        {
            return coursename;
        }
        public void setcoursename(String coursename)
        {
            this.coursename = coursename;
        }
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
        List<Pair<String,Double>> scorelist=studentService.getScore();
        Agpa.setText(Double.toString(studentService.averageGPA()));
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
