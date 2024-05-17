package cn.ustc.edu.course_selection_system.Database;

public interface Person {
    void AddCoursePair();
    void DeleteCoursePair();
    void GetChosenCourseList(int id);
}
