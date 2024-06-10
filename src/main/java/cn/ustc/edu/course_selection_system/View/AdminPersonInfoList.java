package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import cn.ustc.edu.course_selection_system.Service.CourseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminPersonInfoList {

    private String AdminID;
    static Integer  PageSize=12;
    @FXML
    private TableColumn<PersonInfo, Integer> AdmissionYear;

    @FXML
    private Button Back;

    @FXML
    private Button ChangeCode;

    @FXML
    private TableColumn<PersonInfo, String> Gender;

    @FXML
    private TableColumn<PersonInfo, String> Id;

    @FXML
    private TextField IdOrName;

    @FXML
    private TableColumn<PersonInfo, String> Major;

    @FXML
    private TableColumn<PersonInfo, String> Name;

    @FXML
    private Pagination Pager;

    @FXML
    private TableColumn<PersonInfo, String> Password;

    @FXML
    private TableColumn<PersonInfo, String> PhoneNumber;

    @FXML
    private RadioButton Course;

    @FXML
    private RadioButton StuTeaList;

    @FXML
    private RadioButton CourseList;

    @FXML
    private Button Search;

    @FXML
    private TextField SearchMajor;

    @FXML
    private TextField SearchYear;

    @FXML
    private RadioButton StudentAndTeacher;

    @FXML
    private TableView<PersonInfo> Table;

    @FXML
    private Pagination Paging;

    @FXML
    private Button DelPerson;

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
    {
        if(StudentAndTeacher.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/AdminRegisStudent.fxml"));
            Parent root=loader.load();
            AdminRegisStudentController adminRegisStudentController =loader.getController();
//            adminRegisStudentController.start(AdminID);
            Stage stage=(Stage) StudentAndTeacher.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
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
    {}
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
    void initialize() {
        SetColumn();
        SetUpPaging();
    }

    void SetColumn(){
        Id.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Id"));
        Name.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Name"));
        Gender.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Gender"));
        Major.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Major"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("PhoneNumber"));
        Password.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Password"));
        AdmissionYear.setCellValueFactory(new PropertyValueFactory<>("AdmissionYear"));
        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    void SetUpPaging(){
        Paging.setPageCount(IdOrName.getText().isEmpty()?(int) Math.ceil((double) AdminService.getNumOfStuByCons(Major.getText().isEmpty()?"%":Major.getText(),SearchYear.getText().isEmpty()?"%":SearchYear.getText()) / PageSize):1);
        Paging.setPageFactory(this::getTable);
    }

    TableView<PersonInfo> getTable(Integer index) {
        Table.setItems(FXCollections.observableArrayList(getData(index,PageSize)) );
        return Table;
    }
    List<PersonInfo> getData(Integer page, Integer limit){
        List<PersonInfo> list;

        if(!IdOrName.getText().isEmpty()){
            list=(AdminService.getPersonInfo(IdOrName.getText()));
        }
        else {
            list=AdminService.getPersonInfo(SearchMajor.getText().isEmpty()?"%":Major.getText(),SearchYear.getText().isEmpty()?"%":SearchYear.getText(),page,limit);
        }
        return list;
    }


    @FXML
    void onSearchClicked() {
        SetUpPaging();
    }

    @FXML
    void onDelPersonClicked()
    {
        List<PersonInfo> list=Table.getSelectionModel().getSelectedItems();
        AdminService.DelID(list);
        SetUpPaging();
    }
}
