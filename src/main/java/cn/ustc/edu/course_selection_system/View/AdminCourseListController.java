package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<CourseEntity> Table;
    @FXML
    private TableColumn<CourseEntity, String> CourseName;

    @FXML
    private TableColumn<CourseEntity, String> Time;
    @FXML
    private TableColumn<CourseEntity, String> Teacher;

    @FXML
    private Pagination Paging;

    public void Start(String AdminID){
        this.AdminID = AdminID;


        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
//        Teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        CourseName.setCellValueFactory(new PropertyValueFactory<>("Number"));
        setupPaging();
        Table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
    @FXML
    void initialize() {
        Start("");
    }

    private void setupPaging(){
        Paging.setPageCount(1);
        Paging.setPageFactory(this::Paging);
    }

    ObservableList<CourseEntity> data(){
        List<CourseEntity> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            data.add(new CourseEntity());
        }

        ObservableList<CourseEntity> list = FXCollections.observableArrayList(data);
        return list;
    }


    private TableView<CourseEntity> Paging(Integer index) {
        Table.setItems(data());
        return Table;
    }
}
/**
 *     private void loadEquipmentData() {
 *         try (BufferedReader br = new BufferedReader(new FileReader("G:\\Eclipes\\FinalHomework1\\src\\data\\equipment.txt"))) {
 *             String line;
 *             while ((line = br.readLine()) != null) {
 *                 String[] parts = line.split(",");
 *                 Equipment equipment = new Equipment(
 *                         parts[0],
 *                         parts[1],
 *                         parts[2],
 *                         parts[3],
 *                         ""
 *                 );
 *                 equipmentList.add(equipment);
 *             }
 *         } catch (IOException e) {
 *             e.printStackTrace();
 *         }
 *     }
 *
 *     private void setupTableColumns() {
 *         selectColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
 *         selectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectColumn));
 *
 *         idColumn.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
 *         categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
 *
 *         nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
 *         statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
 *     }
 *
 *     private void setupPagination() {
 *         int pageCount = (int) Math.ceil(equipmentList.size() / (double) ROWS_PER_PAGE);
 *         pagination.setPageCount(pageCount);
 *         pagination.setPageFactory(this::createPage);
 *     }
 *
 *     private TableView<Equipment> createPage(int pageIndex) {
 *         int fromIndex = pageIndex * ROWS_PER_PAGE;
 *         int toIndex = Math.min(fromIndex + ROWS_PER_PAGE, equipmentList.size());
 *
 *         FilteredList<Equipment> filteredData = new FilteredList<>(equipmentList, p -> true);
 *         SortedList<Equipment> sortedData = new SortedList<>(filteredData);
 *
 *         equipmentTable.setItems(FXCollections.observableArrayList(sortedData.subList(fromIndex, toIndex)));
 *         return equipmentTable;
 *     }
 * }
 */