package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Service.StudentService;
import cn.ustc.edu.course_selection_system.Util.CourseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StudentCourseListController {
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
//            studentHandleCourseController.start(id);
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
    {}
    class tableline
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
    }
    @FXML
    private TableView<tableline> table;
    public void start(String id)
    {
        this.id=id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        List<CourseEntity> studentcourse=studentService.getRelatedCourse();
        CourseTable courseTable=new CourseTable(studentcourse);
        Name.setText(studentEntity.getName());
        ObservableList<tableline> list= FXCollections.observableArrayList();
        table=new TableView<>(list);
        String time[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        for(int i=1;i<=13;i++)
        {
            List<String> timecourse=courseTable.TimeCourse(time[i],"1");
            table.getItems().add(new tableline(timecourse.get(0),timecourse.get(1),timecourse.get(2), timecourse.get(3), timecourse.get(4), timecourse.get(5), timecourse.get(6)));
        }
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
        List<CourseEntity> studentcourse=studentService.getRelatedCourse();
        CourseTable courseTable=new CourseTable(studentcourse);
        Name.setText(studentEntity.getName());
        ObservableList<tableline> list= FXCollections.observableArrayList();
        table=new TableView<>(list);
        String time[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13"};
        for(int i=1;i<=13;i++)
        {
            List<String> timecourse=courseTable.TimeCourse(time[i],Week);
            table.getItems().add(new tableline(timecourse.get(0),timecourse.get(1),timecourse.get(2), timecourse.get(3), timecourse.get(4), timecourse.get(5), timecourse.get(6)));
        }
    }
}
