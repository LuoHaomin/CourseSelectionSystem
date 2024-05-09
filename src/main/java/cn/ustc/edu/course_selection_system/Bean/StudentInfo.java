package cn.ustc.edu.course_selection_system.Bean;

public class StudentInfo extends PersonInfo {

    public StudentInfo(int id, String name, String password, String phoneNumber, String position) {
        super(id, name, password, phoneNumber, position);
    }

    String major;
    int admission_year;

    public StudentInfo(int id, String name, String password, String phoneNumber, String position, String major, int admission_year) {
        super(id, name, password, phoneNumber, position);
        this.major = major;
        this.admission_year = admission_year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAdmission_year() {
        return admission_year;
    }

    public void setAdmission_year(int admission_year) {
        this.admission_year = admission_year;
    }
}
