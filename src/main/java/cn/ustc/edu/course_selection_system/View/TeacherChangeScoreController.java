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
import javafx.scene.control.cell.PropertyValueFactory;
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

    /**
     * 内部类——TableView的行
     * 第一列显示学生ID，第二列显示学生姓名，第三列显示输入框用于输入学生成绩
     */
        public class tableline
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
            public TextField getTextField() {return textField;}
            public String getStudentId() {return studentid;}
            public String getStudentName() {return studentname;}
            public void setTextField(TextField t) {textField=t;}
            public void setStudentId(String s) {studentid=s;}
            public void setStudentName(String s) {studentname=s;}
        }
        @FXML
        private TableView<tableline> table;
        @FXML
        private TableColumn<tableline,String> StudentID;
        @FXML
        private TableColumn<tableline,String> StudentName;
        @FXML
        private TableColumn<tableline,TextField> StudentScore;
        public void start(String teacherid,int courseid)
        {
            this.teacherid=teacherid;
            this.courseid=courseid;
            TeacherService teacherService=new TeacherService(teacherid);
            TeacherEntity teacherEntity=teacherService.GetID();
            Name.setText(teacherEntity.getName());

            StudentID.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
            StudentName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
            StudentScore.setCellValueFactory(new PropertyValueFactory<>("TextField"));

            CourseService courseService=new CourseService(courseid);
            List<String> studentlist=courseService.GetStudentInCourse();//获得选课所有学生列表

            ObservableList<tableline> list= FXCollections.observableArrayList();
            for (String s : studentlist) {
                StudentService studentService = new StudentService(s);
                StudentEntity studentEntity = studentService.GetID();
                list.add(new tableline(studentEntity));
            }
            table.setItems(list);
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
            TeacherService teacherService=new TeacherService(teacherid);
            for( tableline row: items)
            {
                String studentid=row.getStudentId();
                double score;
                try {
                    if(row.getTextField().getText().isEmpty())
                        score=teacherService.GetScore(courseid,studentid);//如果未输入成绩，则保留为原成绩
                    else score = Double.parseDouble(row.getTextField().getText());
                }
                catch(Exception exception)
                {
                    return;//如果输入不为数字，则直接关闭函数，不进行记录
                }
                studentscore.add(new Pair<>(studentid,score));
            }
            if(!teacherService.excellentRate(courseid,studentscore)) {//如果优秀率不超过40%
                teacherService.importStudentsScore(courseid, studentscore);
            }
            else {
                wrong.setVisible(true);
            }
        }
    }