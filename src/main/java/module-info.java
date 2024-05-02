module cn.ustc.edu.courseselectionsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens cn.ustc.edu.course_selection_system to javafx.fxml;
    exports cn.ustc.edu.course_selection_system;
    exports cn.ustc.edu.course_selection_system.View;
    opens cn.ustc.edu.course_selection_system.View to javafx.fxml;
}