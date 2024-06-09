package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import cn.ustc.edu.course_selection_system.Service.CourseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminCourseListController {
    static int PageSize = 12;
    private String AdminID;
    @FXML
    private Button AddCourse;

    @FXML
    private Button Back;

    @FXML
    private Button ChangeCode;

    @FXML
    private Label Name;

    @FXML
    private RadioButton Score;

    @FXML
    private RadioButton Score1;

    @FXML
    private RadioButton Score11;

    @FXML
    private RadioButton Student;



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
    private Button Search;

    private String SearchWord;

    @FXML
    void initialize() {
        SearchWord="";
        SetColumn();
        setupPaging();

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
}

