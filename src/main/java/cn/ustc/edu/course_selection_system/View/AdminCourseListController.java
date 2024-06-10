package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import cn.ustc.edu.course_selection_system.Service.CourseService;
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
import java.util.List;

public class AdminCourseListController {
    static int PageSize = 12;
    private String AdminID;


    @FXML
    private Button Back;

    @FXML
    private Button ChangeCode;

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
    private TableView<CourseInfo> Table;
    @FXML
    private TableColumn<CourseInfo, String> CourseName;

    @FXML
    private TableColumn<CourseInfo, String> Time;
    @FXML
    private TableColumn<CourseInfo, String> Teacher;

    @FXML
    private TableColumn<CourseInfo, String> Period;

    @FXML
    private TableColumn<CourseInfo, Double> Credit;
    @FXML
    private TableColumn<CourseInfo, Integer> Capacity;
    @FXML
    private Pagination Paging;
    @FXML
    private TextField SearchName;
    @FXML
    private Button DelCourse;
    @FXML
    private Button Search;

    @FXML
    private String SearchWord;

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
    {}

    @FXML
    void initialize() {
        SearchWord="";
        SetColumn();
        setupPaging();
        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void SetColumn(){
        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        Credit.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
    }



    private void setupPaging(){

        Paging.setPageCount((int) Math.ceil((double) CourseService.getNumberOfCourses() / PageSize));
        Paging.setPageFactory(this::Paging);
    }

    ObservableList<CourseInfo> GetData(Integer page, Integer pageSize){
        return FXCollections.observableArrayList(CourseService.getCourseInfoList(page,pageSize));
    }

    private TableView<CourseInfo> Paging(Integer index) {
        Table.setItems(GetData(index,PageSize));
        return Table;
    }

    @FXML
    void onSearchClicked(ActionEvent event) {
        SearchWord = SearchName.getText();
    }

    @FXML
    void onDelCourseClicked(ActionEvent event) {
        List<CourseInfo> courseInfoList = Table.getSelectionModel().getSelectedItems();
        AdminService.DelCourse(courseInfoList);
    }
}

