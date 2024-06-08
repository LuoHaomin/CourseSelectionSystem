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
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.*;

public class TeacherChangeScoreController {
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
        @FXML
        private Button backselect;
        @FXML
        private RadioButton Student;
        @FXML
        private RadioButton Score;
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
        {
            if(Student.isSelected())
            {
                FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/TeacherWelcome.fxml"));
                Parent root=loader.load();
                TeacherWelcomeController teacherWelcomeController =loader.getController();
                teacherWelcomeController.start(teacherid,courseid);
                Stage stage=(Stage) Student.getScene().getWindow();
                Scene scene=new Scene(root,600,400);
                stage.setScene(scene);
                stage.show();
            }
        }
        @FXML
        public void HandleScore(ActionEvent event) throws IOException
        {}
        class tableline
        {
            String studentid;
            String studentname;
            TextField textField;
            public tableline(StudentEntity student)
            {
                studentid=student.getId();
                studentname=student.getName();
                textField=new TextField("请输入分数");
            }
            public TextField getTextField()
            {
                return textField;
            }
            public String getID()
            {
                return studentid;
            }
        }
        @FXML
        private TableView<tableline> table;
        public void start(String teacherid,int courseid)
        {
            this.teacherid=teacherid;
            this.courseid=courseid;
            TeacherService teacherService=new TeacherService(teacherid);
            TeacherEntity teacherEntity=teacherService.GetID();
            Name.setText(teacherEntity.getName());
            CourseService courseService=new CourseService(courseid);
            List<String> studentlist=courseService.GetStudentInCourse();
            ObservableList<tableline> list= FXCollections.observableArrayList();
            table=new TableView<>(list);
            int size=studentlist.size();
            for(int i=0;i<size;i++)
            {
                StudentService studentService=new StudentService(studentlist.get(i));
                StudentEntity studentEntity=studentService.GetID();
                table.getItems().add(new tableline(studentEntity));
            }
        }
        @FXML
        private Label wrong;
        @FXML
        private Button summit;
        @FXML
        private void Handlesummit(ActionEvent event) throws Exception
        {
            List<Pair<String,Double>> studentscore=new ArrayList<>();
            ObservableList<tableline> items=table.getItems();
            for( tableline row: items)
            {
                String studentid=row.getID();
                double score;
                try {
                    score = Double.parseDouble(row.getTextField().getText());
                }
                catch(Exception exception)
                {
                    return;
                }
                studentscore.add(new Pair<>(studentid,score));
            }
            TeacherService teacherService = new TeacherService(teacherid);
            if(!teacherService.excellentRate(courseid,studentscore)) {
                teacherService.importStudentsScore(courseid, studentscore);
            }
            else {
                wrong.setVisible(true);
            }
        }
    }