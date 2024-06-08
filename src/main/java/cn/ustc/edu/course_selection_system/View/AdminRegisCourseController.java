package cn.ustc.edu.course_selection_system.View;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private TableColumn<?, ?> CourseName;

    @FXML
    private TableColumn<?, ?> CourseTime;

    @FXML
    private TableColumn<?, ?> Credit;

    @FXML
    private Button ImportCourse;

    @FXML
    private Label Name;

    @FXML
    private TableColumn<?, ?> Peroid;

    @FXML
    private RadioButton Score;

    @FXML
    private RadioButton Score1;

    @FXML
    private RadioButton Score11;

    @FXML
    private RadioButton Student;

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> Teacher;

    @FXML
    private TableColumn<?, ?> Time;


    @FXML
    void initialize() {

    }

    @FXML
    protected void onImportCourseClick() {
        FileChooser chooser=new FileChooser();

        chooser.setTitle("打开图片");                //设置窗口标题，默认为“打开”
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            System.out.println(chooser.showOpenDialog(stage).getAbsolutePath());
        }
        catch (Exception ignore) {}
    }
    @FXML
    protected void onBackClick() {}

    private void GetData(){

    }

}
