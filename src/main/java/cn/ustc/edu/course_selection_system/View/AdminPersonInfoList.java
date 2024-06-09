package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import cn.ustc.edu.course_selection_system.Service.AdminService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class AdminPersonInfoList {

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
    private RadioButton Score;

    @FXML
    private RadioButton Score1;

    @FXML
    private RadioButton Score11;

    @FXML
    private Button Search;

    @FXML
    private TextField SearchMajor;

    @FXML
    private TextField SearchYear;

    @FXML
    private RadioButton Student;

    @FXML
    private TableView<PersonInfo> Table;

    @FXML
    void initialize() {
        SetColumn();

    }

    void SetColumn(){
        Id.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Id"));
        Name.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Name"));
        Gender.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Gender"));
        Major.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Major"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("PhoneNumber"));
        Password.setCellValueFactory(new PropertyValueFactory<PersonInfo, String>("Password"));
        AdmissionYear.setCellValueFactory(new PropertyValueFactory<PersonInfo, Integer>("AdmissionYear"));
    }

    List<PersonInfo> getData(){
        List<PersonInfo> list = new ArrayList<PersonInfo>();
        list.addAll(AdminService.getPersonInfo(IdOrName.getText()));
        list.addAll(AdminService.getPersonInfo(IdOrName.getText(),SearchMajor.getText(),SearchYear.getText()));
        return list;
    }

    @FXML
    void onSearchClicked() {
        List<PersonInfo> list = getData();
        Table.getItems().clear();
        Table.setItems(FXCollections.observableArrayList(list));
    }

}
