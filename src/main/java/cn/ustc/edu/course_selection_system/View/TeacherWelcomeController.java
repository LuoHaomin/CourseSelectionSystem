package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Service.CourseService;
import cn.ustc.edu.course_selection_system.Service.StudentService;
import cn.ustc.edu.course_selection_system.Service.TeacherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class TeacherWelcomeController {
    private String teacherid;
    private int courseid=0;
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
        changeCodeSceneController.start(teacherid);
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
    class tableline
    {
        String studentid;
        String studentname;
        public tableline(StudentEntity studentEntity) {
            studentid = studentEntity.getId();
            studentname = studentEntity.getName();
        }
    }
    @FXML
    private Button backselect;
    @FXML
    private RadioButton Student;
    @FXML
    private RadioButton Score;
    @FXML
    private TableView<tableline> Table;

    public void start(String tearcherid, int courseid)
    {
        this.teacherid=tearcherid;
        this.courseid=courseid;
        TeacherService teacherService=new TeacherService(teacherid);
        TeacherEntity teacherEntity=teacherService.GetID();
        Name.setText(teacherEntity.getName());
        CourseService courseService=new CourseService(courseid);
        List<String> studentlist=courseService.GetStudentInCourse();
        ObservableList<tableline> list=FXCollections.observableArrayList();
        Table=new TableView<>(list);
        int size= list.size();

        for(int i=0;i<size;i++)
        {
            StudentService studentService=new StudentService(studentlist.get(i));
            StudentEntity studentEntity=studentService.GetID();
            Table.getItems().add(new tableline(studentEntity));
        }
    }
    @FXML
    public void Handlebackselect(ActionEvent event) throws IOException
    {
        FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherLogin.fxml"));
        Parent root=loader.load();
        TeacherLoginController teacherloginController=loader.getController();
        teacherloginController.start(teacherid);
        Stage stage=(Stage) backselect.getScene().getWindow();
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void HandleStudent(ActionEvent event) throws IOException
    {}
    @FXML
    public void HandleScore(ActionEvent event) throws IOException
    {
        if(Score.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherChangeScore.fxml"));
            Parent root=loader.load();
            TeacherChangeScoreController teacherChangeScoreController =loader.getController();
            teacherChangeScoreController.start(teacherid,courseid);
            Stage stage=(Stage) Score.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

}
