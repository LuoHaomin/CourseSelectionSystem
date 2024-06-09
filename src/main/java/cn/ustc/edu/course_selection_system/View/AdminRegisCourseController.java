package cn.ustc.edu.course_selection_system.View;
import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Service.CourseService;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class AdminRegisCourseController {

    @FXML
    private AnchorPane root;
    @FXML
    private Button AddCourse;

    @FXML
    private Button Back;

    @FXML
    private Button ChangeCode;

    @FXML
    private Button Commit;

    @FXML
    private TableColumn<CourseInfo, String> CourseName;

    @FXML
    private TableColumn<CourseInfo,  String> Time;

    @FXML
    private TableColumn<CourseInfo, Double> Credit;

    @FXML
    private Button ImportCourse;

    @FXML
    private Label Name;

    @FXML
    private TableColumn<CourseInfo,  String> Period;

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
    private TableColumn<CourseInfo,  String> Teacher;

    @FXML
    private TableColumn<CourseInfo,Integer> Capacity;



    private List<CourseInfo> CourseList;

    @FXML
    void initialize() {
        CourseList = new ArrayList<>();
        SetColumn();
    }

    @FXML
    protected void onImportCourseClick() {
        FileChooser chooser=new FileChooser();

        chooser.setTitle("打开文件");                //设置窗口标题，默认为“打开”
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("CSV", "*.csv"));
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            System.out.println(chooser.showOpenDialog(stage).getAbsolutePath());
        }
        catch (Exception ignore) {}
    }

    @FXML
    protected void onBackClick() {}

    @FXML
    protected void onAddCourseClick() {
        CourseInfo courseInfo = new CourseInfo();
        CourseList.add(courseInfo);
        Table.setItems(FXCollections.observableArrayList(CourseList));
    }
    @FXML
    protected void onCommitClick() {
        for (CourseInfo courseInfo : CourseList) {
            System.out.println(courseInfo.getCredit());
        }
    }

    private void SetColumn(){
        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        Credit.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));

        CourseName.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        CourseName.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setCourseName(event.getNewValue());
        });

        Time.setCellFactory(TextFieldTableCell.forTableColumn());
        Time.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setTime(event.getNewValue());
        });

        Teacher.setCellFactory(TextFieldTableCell.forTableColumn());
        Teacher.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setTeacher(event.getNewValue());
        });

        Period.setCellFactory(TextFieldTableCell.forTableColumn());
        Period.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setPeriod(event.getNewValue());
        });

        Credit.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        Credit.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setCredit(event.getNewValue());
        });

        Capacity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Capacity.setOnEditCommit(event -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setCapacity(event.getNewValue());
        });


    }
}
