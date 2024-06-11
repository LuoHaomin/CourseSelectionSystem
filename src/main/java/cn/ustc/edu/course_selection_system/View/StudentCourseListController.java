package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Service.PageJump;
import cn.ustc.edu.course_selection_system.Service.StudentService;
import cn.ustc.edu.course_selection_system.Util.CourseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StudentCourseListController implements Page{
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
            PageJump.JumpTo("/cn/ustc/edu/course_selection_system/StudentHandleCourse.fxml",id,(Stage)Score.getScene().getWindow());
        }
    }
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
    {}



    public static class tableline
    {
        String Monday;
        String Tuesday;
        String Wednesday;
        String Thursday;
        String Friday;
        String Saturday;
        String Sunday;
        public tableline(String Monday,String Tuesday,String Wednesday,String Thursday,String Friday,String Saturday,String Sunday)
        {
            this.Monday=Monday;
            this.Tuesday=Tuesday;
            this.Wednesday=Wednesday;
            this.Thursday=Thursday;
            this.Friday=Friday;
            this.Saturday=Saturday;
            this.Sunday=Sunday;
        }
        public String getMonday() {return Monday;}
        public void setMonday(String Monday) {
            this.Monday = Monday;
        }
        public String getTuesday() {
            return Tuesday;
        }
        public void setTuesday(String Tuesday) {
            this.Tuesday = Tuesday;
        }
        public String getWednesday() {
            return Wednesday;
        }
        public void setWednesday(String Wednesday) {
            this.Wednesday = Wednesday;
        }
        public String getThursday() {
            return Thursday;
        }
        public void setThursday(String Thursday) {
            this.Thursday = Thursday;
        }
        public String getFriday() {
            return Friday;
        }
        public void setFriday(String Friday) {
            this.Friday = Friday;
        }
        public String getSaturday() {
            return Saturday;
        }
        public void setSaturday(String Saturday) {
            this.Saturday = Saturday;
        }
        public String getSunday() {
            return Sunday;
        }
        public void setSunday(String Sunday) {
            this.Sunday = Sunday;
        }
    }
    @FXML
    private TableView<tableline> table;
    @FXML
    private TableColumn<tableline,String> Mon;
    @FXML
    private TableColumn<tableline,String> Tue;
    @FXML
    private TableColumn<tableline,String> Wed;
    @FXML
    private TableColumn<tableline,String> Thu;
    @FXML
    private TableColumn<tableline,String> Fri;
    @FXML
    private TableColumn<tableline,String> Sat;
    @FXML
    private TableColumn<tableline,String> Sun;
    public void start(String id)
    {
        this.id=id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        Name.setText(studentEntity.getName());
        List<CourseEntity> StudentCourse=studentService.getRelatedCourses();
        CourseTable courseTable=new CourseTable(StudentCourse);
        Mon.setCellValueFactory(new PropertyValueFactory<>("Monday"));
        Tue.setCellValueFactory(new PropertyValueFactory<>("Tuesday"));
        Wed.setCellValueFactory(new PropertyValueFactory<>("Wednesday"));
        Thu.setCellValueFactory(new PropertyValueFactory<>("Thursday"));
        Fri.setCellValueFactory(new PropertyValueFactory<>("Friday"));
        Sat.setCellValueFactory(new PropertyValueFactory<>("Saturday"));
        Sun.setCellValueFactory(new PropertyValueFactory<>("Sunday"));
        ObservableList<tableline> list= FXCollections.observableArrayList();
        String[] time ={"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        for(int i=1;i<=13;i++)
        {
            List<String> timecourse=courseTable.TimeCourse(time[i],"1");
            list.add(new tableline(timecourse.get(0), timecourse.get(1), timecourse.get(2), timecourse.get(3), timecourse.get(4), timecourse.get(5), timecourse.get(6)));
        }
        table.setItems(list);
    }
    @FXML
    private TextField textfield;
    @FXML
    private Button Go;
    @FXML
    public void HandleGo(ActionEvent event) throws IOException
    {
        String Week=textfield.getText();
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        List<CourseEntity> studentcourse=studentService.getRelatedCourses();
        CourseTable courseTable=new CourseTable(studentcourse);
        Name.setText(studentEntity.getName());
        ObservableList<tableline> list= FXCollections.observableArrayList();
        String time[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        for(int i=1;i<=13;i++)
        {
            List<String> timecourse=courseTable.TimeCourse(time[i],Week);
            list.add(new tableline(timecourse.get(0), timecourse.get(1), timecourse.get(2), timecourse.get(3), timecourse.get(4), timecourse.get(5), timecourse.get(6)));
        }
        table.setItems(list);
    }
}
