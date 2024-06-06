package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import jakarta.persistence.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class AdminCourseListController {

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
    private Button lastPage;

    @FXML
    private Button nextPage;

    @FXML
    private Label pageIndex;

    @FXML
    private TableView<CI> Table;
    @FXML
    private TableColumn<CI, String> CourseName;

    @FXML
    private TableColumn<CI, String> Time;
    @FXML
    private TableColumn<CI, String> Teacher;

    public void Start(String AdminID){
        this.AdminID = AdminID;

        List<CI> data = new ArrayList<>();
        for (Integer i = 0; i < 7; i++) {
            data.add(new CI("123","234"+i.toString(),"234"));
        }

        ObservableList<CI> list = FXCollections.observableArrayList(data);
        Time.setCellValueFactory(new PropertyValueFactory<CI, String>("Time"));

        Table.setItems(list);
//        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
    @FXML
    void initialize() {
        Start("");
    }

    public class CI{
        private final SimpleStringProperty Name;
        private String Time;
        private final SimpleStringProperty Teacher;
        public CI(String Name,String Time,String Teacher){
            this.Name = new SimpleStringProperty(Name);
            this.Time = Time;
            this.Teacher = new SimpleStringProperty(Teacher);
        }

        public String getName() {
            return Name.get();
        }

//        public final SimpleStringProperty nameProperty() {
//            return Name;
//        }

        public void setName(String name) {
            this.Name.set(name);
        }

        public String getTime() {
            return Time;
        }

//        public final SimpleStringProperty timeProperty() {
//            return Time;
//        }

        public void setTime(String time) {
            this.Time = time;
        }

        public String getTeacher() {
            return Teacher.get();
        }

//        public final SimpleStringProperty teacherProperty() {
//            return Teacher;
//        }

        public void setTeacher(String teacher) {
            this.Teacher.set(teacher);
        }
    }
}
