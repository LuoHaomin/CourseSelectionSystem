module cn.ustc.edu.courseselectionsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    requires jakarta.persistence;

    requires org.hibernate.orm.core;
    requires java.naming;
//    requires org.hibernate.orm.jpamodelgen;

    opens cn.ustc.edu.course_selection_system to javafx.fxml;
    opens cn.ustc.edu.course_selection_system.View to javafx.fxml;
    opens cn.ustc.edu.course_selection_system.Bean ;

    exports cn.ustc.edu.course_selection_system;
    exports cn.ustc.edu.course_selection_system.View;
}