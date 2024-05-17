package cn.ustc.edu.course_selection_system.Bean;

public class CourseInfo {
    int id;
    /**
     * 课程编码（每种科目对应唯一编码）
     */
    int code;

    String name;
    String teacher;
    /**
     * 课程时间（如周六（1，2，3））
     */
    String time;

    /**
     * 课程起始周数（如2-4（单））
     */
    String period;
    //Todo：怎么表示更好？

    /**
     * 学分
     */
    int credit;


    public CourseInfo(int id, int code, String name, String teacher, String time, String period, int credit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.time = time;
        this.period = period;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
