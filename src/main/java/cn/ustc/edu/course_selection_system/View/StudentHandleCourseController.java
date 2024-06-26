package cn.ustc.edu.course_selection_system.View;

import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import cn.ustc.edu.course_selection_system.Service.CourseService;
import cn.ustc.edu.course_selection_system.Service.StudentService;
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

public class StudentHandleCourseController {
    private String id;
    private int PageSize=12;
    @FXML
    private Label Name;
    @FXML
    private Button ChangeCode;
    @FXML
    private Button Back;

    @FXML
    private void HandleChangeCode(ActionEvent event) throws IOException
    {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/ChangCodeScene.fxml"));
        Parent root=loader.load();
        ChangeCodeSceneController changeCodeSceneController=loader.getController();
        changeCodeSceneController.start(id);
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
    private RadioButton Course;
    @FXML
    private RadioButton Score;
    @FXML
    private RadioButton CourseList;
    @FXML
    private RadioButton Program;
    @FXML
    public void HandleCourse(ActionEvent event) throws IOException
    {}
    @FXML
    public void HandleScore(ActionEvent event) throws IOException
    {
        if(Score.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentScore.fxml"));
            Parent root=loader.load();
            StudentScoreController studentScoreController =loader.getController();
            studentScoreController.start(id);
            Stage stage=(Stage) Score.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleProgram(ActionEvent event) throws IOException
    {
        if(Program.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentProgram.fxml"));
            Parent root=loader.load();
            StudentProgramController studentProgramController =loader.getController();
            studentProgramController.start(id);
            Stage stage=(Stage) Program.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void HandleCourseList(ActionEvent event) throws IOException
    {
        if(CourseList.isSelected())
        {
            FXMLLoader  loader=new FXMLLoader(getClass().getResource("/cn/ustc/edu/course_selection_system/StudentCourseList.fxml"));
            Parent root=loader.load();
            StudentCourseListController studentCourseListController =loader.getController();
            studentCourseListController.start(id);
            Stage stage=(Stage) Program.getScene().getWindow();
            Scene scene=new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    Label symbol;
    /**
     * 内部类——TableView的行
     * 第一列显示课程名称，第二列显示课程时间，第三列显示授课老师，
     * 第四列显示课程学分，第五列显示课程时段，第六列显示课堂容量，第七列显示选课/退课按钮
     */
    public class tableline
    {
        String CourseName;
        String Time;
        String Teacher;
        double Credit;
        String Period;
        int Capacity;
        Button Conduct;

        public tableline(String CourseName, String Time, String Teacher, double Credit,
                         String Period, int Capacity,String StudentID,int CourseID,boolean selectordrop)
        {
            this.CourseName = CourseName;
            this.Time = Time;
            this.Teacher = Teacher;
            this.Credit = Credit;
            this.Period = Period;
            this.Capacity = Capacity;
            StudentService studentService=new StudentService(StudentID);
            if (selectordrop)
            {
                Conduct=new Button("选课");
                Conduct.setOnAction(event -> {
                    if(!studentService.chooseCourse(CourseID))
                    {
                        symbol.setText("选课未成功");
                    }
                    else {
                        setTable(id);
                    }
                });
            }
            else{
                Conduct=new Button("退课");
                Conduct.setOnAction(event -> {
                    if(!studentService.dropCourse(CourseID))
                    {
                        symbol.setText("退课未成功");
                    }
                    else {
                        setTable(id);
                    }
                });
            }
        }
        public String getCourseName() {return CourseName;}
        public String getTime() {return Time;}
        public String getTeacher() {return Teacher;}
        public double getCredit() {return Credit;}
        public String getPeriod() {return Period;}
        public int getCapacity() {return Capacity;}
        public void setCourseName(String CourseName) {this.CourseName = CourseName;}
        public void setTime(String Time) {this.Time = Time;}
        public void setTeacher(String Teacher) {this.Teacher = Teacher;}
        public void setCredit(double Credit) {this.Credit = Credit;}
        public void setPeriod(String Period) {this.Period = Period;}
        public void setCapacity(int Capacity) {this.Capacity = Capacity;}
        public Button getConduct() {return Conduct;}
    }
    @FXML
    private TableView<tableline> Table;
    @FXML
    private Pagination Paging;
    @FXML
    private TableColumn<tableline,String> CourseName;
    @FXML
    private TableColumn<tableline,String> Time;
    @FXML
    private TableColumn<tableline,String> Teacher;
    @FXML
    private TableColumn<tableline,Double> Credit;
    @FXML
    private TableColumn<tableline,String> Period;
    @FXML
    private TableColumn<tableline,Integer> Capacity;
    @FXML
    private TableColumn<tableline,Button> Conduct;
    public void start(String id)
    {
        this.id = id;
        StudentService studentService=new StudentService(id);
        StudentEntity studentEntity=studentService.GetID();
        Name.setText(studentEntity.getName());

        CourseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Teacher.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        Credit.setCellValueFactory(new PropertyValueFactory<>("Credit"));
        Period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        Conduct.setCellValueFactory(new PropertyValueFactory<>("Conduct"));

        setTable(id);
    }

    /**
     * 设置表格样式及页码样式
     * @param id
     */
    public void setTable(String id)
    {
        StudentService studentService=new StudentService(id);
        int studentcoursesize=studentService.getNumberOfCourse();
        int droppage=(int) Math.ceil((double)studentcoursesize/ PageSize);
        int selectpage=(int)Math.ceil((double)CourseService.getNumberOfCourses()/PageSize);
        int allpage=droppage+selectpage;
        //设置在未点击页码时第一页的表格内容
        ObservableList<tableline> list= FXCollections.observableArrayList();
        if(droppage==0)//如果学生没有选任何一节课，第一页直接显示是选课界面
        {
            List<CourseInfo> firstpage=CourseService.getCourseInfoList(0,PageSize);
            for (CourseInfo courseInfo : firstpage) {
                list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(),
                        courseInfo.getTeacher(), courseInfo.getCredit(), courseInfo.getPeriod(),
                        courseInfo.getCapacity(), id, courseInfo.getCourseEntity().getId(), true));
            }
            Table.setItems(list);
        }
        else {//否则，第一页显示退课界面
            List<CourseInfo> firstpage=studentService.getRelatedCourse(0,PageSize);
            for (CourseInfo courseInfo : firstpage) {
                list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(), courseInfo.getTeacher(),
                        courseInfo.getCredit(), courseInfo.getPeriod(), courseInfo.getCapacity(), id,
                        courseInfo.getCourseEntity().getId(), false));
            }
            Table.setItems(list);
        }

        Paging.setPageCount(allpage);
        Paging.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {//当点击了页码时
            list.clear();//清空当前表格内容
            int currentpage=Paging.currentPageIndexProperty().get();
            if(currentpage<droppage)//如果在退课界面
            {
                List<CourseInfo> thispage=studentService.getRelatedCourse(currentpage,PageSize);
                for (CourseInfo courseInfo : thispage) {
                    list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(),
                            courseInfo.getTeacher(), courseInfo.getCredit(), courseInfo.getPeriod(),
                            courseInfo.getCapacity(), id, courseInfo.getCourseEntity().getId(), false));
                }
                Table.setItems(list);
            }
            else {//如果在选课界面
                currentpage=currentpage-droppage+1;
                List<CourseInfo> thispage=CourseService.getCourseInfoList(currentpage,PageSize);
                for (CourseInfo courseInfo : thispage) {
                    list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(), courseInfo.getTeacher(), courseInfo.getCredit(), courseInfo.getPeriod(), courseInfo.getCapacity(), id, courseInfo.getCourseEntity().getId(), true));
                }
                Table.setItems(list);
            }
        });
    }
    @FXML
    private TextField QCourseName;
    public void setQCourseName(String qCourseName)
    {
        QCourseName.setText(qCourseName);
    }
    @FXML
    private Button Find;
    @FXML
    public void HandleFind(ActionEvent event)//根据课程完整名称搜索课程
    {
        String qCourseName=QCourseName.getText();
        Long size=CourseService.GetNumberOfCourseInfoByName(qCourseName);
        List<CourseInfo> firstpage=CourseService.GetCourseInfoByName(qCourseName,0,PageSize);
        //设置表格第一页内容
        ObservableList<tableline> list= FXCollections.observableArrayList();
        for (CourseInfo courseInfo : firstpage) {
            list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(), courseInfo.getTeacher(),
                    courseInfo.getCredit(), courseInfo.getPeriod(), courseInfo.getCapacity(), id,
                    courseInfo.getCourseEntity().getId(), false));
        }
        Table.setItems(list);

        Paging.setPageCount((int) Math.ceil((double)size.intValue()/ PageSize));
        Paging.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {//点击了页码时
            list.clear();//清空表格内容
            int currentpage=Paging.currentPageIndexProperty().get();
            List<CourseInfo> thispage =CourseService.GetCourseInfoByName(qCourseName,currentpage,PageSize);
            for (CourseInfo courseInfo : thispage) {
                list.add(new tableline(courseInfo.getCourseName(), courseInfo.getTime(), courseInfo.getTeacher(),
                        courseInfo.getCredit(), courseInfo.getPeriod(), courseInfo.getCapacity(), id,
                        courseInfo.getCourseEntity().getId(), false));
            }
            Table.setItems(list);
        });

    }
}