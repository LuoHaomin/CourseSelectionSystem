package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Bean.TeacherEntity;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminRegisStudentController {

    private String AdminID;
    @FXML
    private Button AddStudent;

    @FXML
    private Button AddTeacher;

    @FXML
    private Button Back;

    @FXML
    private Button ChangeCode;

    @FXML
    private Button Commit;

    @FXML
    private Button ImportStu;

    @FXML
    private Button ImportTeacher;

    @FXML
    private TableColumn<StudentEntity, String> Major;

    @FXML
    private Label Name;

    @FXML
    private RadioButton StudentAndTeacher;

    @FXML
    private RadioButton Course;

    @FXML
    private RadioButton StuTeaList;

    @FXML
    private RadioButton CourseList;

    @FXML
    private TableColumn<StudentEntity, String> StuGender;

    @FXML
    private TableColumn<StudentEntity, String> StuID;

    @FXML
    private TableColumn<StudentEntity, String> StuName;

    @FXML
    private TableColumn<StudentEntity, String> StuPassword;

    @FXML
    private TableView<StudentEntity> StuTable;

    @FXML
    private TableColumn<StudentEntity, String> StuTele;

    @FXML
    private RadioButton Student;

    @FXML
    private TableColumn<TeacherEntity, String> TeacherGender;

    @FXML
    private TableColumn<TeacherEntity, String> TeacherID;

    @FXML
    private TableColumn<TeacherEntity, String> TeacherName;

    @FXML
    private TableColumn<TeacherEntity, String> TeacherPassword;

    @FXML
    private TableView<TeacherEntity> TeacherTable;

    @FXML
    private TableColumn<TeacherEntity, String> TeacherTele;

    @FXML
    private TableColumn<StudentEntity, Integer> Year;

    private List<StudentEntity> studentList;
    private List<TeacherEntity> teacherList;
    @FXML
    private void HandleChangeCode(ActionEvent event) throws IOException
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/ChangCodeScene.fxml"));
        Parent root=loader.load();
        ChangeCodeSceneController changeCodeSceneController=loader.getController();
        changeCodeSceneController.start(AdminID);
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
    public void HandleStudentAndTeacher(ActionEvent event) throws IOException
    {}
    @FXML
    public void HandleCourse(ActionEvent event) throws IOException
    {
        if(Course.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/AdminRegisCourse.fxml"));
            Parent root=loader.load();
            AdminRegisCourseController adminRegisCourseController =loader.getController();
//            adminRegisCourseController.start(AdminID);
            Stage stage=(Stage) Course.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleStuTeaList(ActionEvent event) throws IOException
    {
        if(StuTeaList.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/AdminIndivisualList.fxml"));
            Parent root=loader.load();
            AdminPersonInfoList adminPersonInfoList =loader.getController();
//            adminPersonInfoList.start(id);
            Stage stage=(Stage) StuTeaList.getScene().getWindow();
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
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/AdminCourseList.fxml"));
            Parent root=loader.load();
            AdminCourseListController adminCourseListController =loader.getController();
//            adminCourseListController.start(id);
            Stage stage=(Stage) CourseList.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void initialize(){
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        SetColumn();
    }


    void SetColumn(){
        StuID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        StuName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        StuPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Major.setCellValueFactory(new PropertyValueFactory<>("Major"));
        StuGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        StuTele.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Year.setCellValueFactory(new PropertyValueFactory<>("AdmissionYear"));
        TeacherID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        TeacherName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TeacherPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
        TeacherTele.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        TeacherGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));


        StuID.setCellFactory(TextFieldTableCell.forTableColumn());
        StuName.setCellFactory(TextFieldTableCell.forTableColumn());
        StuPassword.setCellFactory(TextFieldTableCell.forTableColumn());
        Major.setCellFactory(TextFieldTableCell.forTableColumn());
        StuGender.setCellFactory(TextFieldTableCell.forTableColumn());
        StuTele.setCellFactory(TextFieldTableCell.forTableColumn());
        Year.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        TeacherID.setCellFactory(TextFieldTableCell.forTableColumn());
        TeacherName.setCellFactory(TextFieldTableCell.forTableColumn());
        TeacherPassword.setCellFactory(TextFieldTableCell.forTableColumn());
        TeacherTele.setCellFactory(TextFieldTableCell.forTableColumn());
        TeacherGender.setCellFactory(TextFieldTableCell.forTableColumn());

        StuID.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setId(event.getNewValue()));
        StuName.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));
        StuPassword.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setPassword(event.getNewValue()));
        Major.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setMajor(event.getNewValue()));
        StuGender.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue()));
        StuTele.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhoneNumber(event.getNewValue()));
        Year.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setAdmissionYear(event.getNewValue()));
        TeacherID.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setId(event.getNewValue()));
        TeacherName.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));
        TeacherPassword.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setPassword(event.getNewValue()));
        TeacherTele.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhoneNumber(event.getNewValue()));
        TeacherGender.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue()));

    }

    @FXML
    void onAddStudentClicked() {
        StudentEntity s = new StudentEntity();
        studentList.add(s);
        StuTable.setItems(FXCollections.observableArrayList(studentList));
    }
    @FXML
    void onAddTeacherClicked() {
        TeacherEntity s = new TeacherEntity();
        teacherList.add(s);
        TeacherTable.setItems(FXCollections.observableArrayList(teacherList));
    }
    @FXML
    void onCommitClicked() {
        AdminService adminService = new AdminService();
        adminService.ImportStudentID(studentList);
        adminService.ImportTeacherID(teacherList);
    }
}
