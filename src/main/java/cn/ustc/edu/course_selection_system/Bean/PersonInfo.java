package cn.ustc.edu.course_selection_system.Bean;

public class PersonInfo {
    boolean isTeacher = false;
    StudentEntity studentEntity;
    TeacherEntity teacherEntity;


    public PersonInfo() {
    }

    public String getName(){
        if(isTeacher){
            return teacherEntity.getName();
        }
        else {
            return studentEntity.getName();
        }
    }
    public String getPassword() {
        if (isTeacher) {
            return teacherEntity.getPassword();
        } else {
            return studentEntity.getPassword();
        }
    }

    public void setPassword(String password) {
        if (isTeacher) {
            teacherEntity.setPassword(password);
        } else {
            studentEntity.setPassword(password);
        }
    }

    public String getGender() {
        if (isTeacher) {
            return teacherEntity.getGender();
        } else {
            return studentEntity.getGender();
        }
    }

    public void setGender(String gender) {
        if (isTeacher) {
            teacherEntity.setGender(gender);
        } else {
            studentEntity.setGender(gender);
        }
    }

    public String getMajor() {
        if (isTeacher) {
            return "";
        } else {
            return studentEntity.getMajor();
        }
    }

    public void setMajor(String major) {
        if (!isTeacher) {
            studentEntity.setMajor(major);
        }
    }

    public String getPhoneNumber() {
        if (isTeacher) {
            return teacherEntity.getPhoneNumber();
        } else {
            return studentEntity.getPhoneNumber();
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isTeacher) {
            teacherEntity.setPhoneNumber(phoneNumber);
        } else {
            studentEntity.setPhoneNumber(phoneNumber);
        }
    }

    public int getAdmissionYear() {
        if (!isTeacher) {
            return 0;
        } else {
            return studentEntity.getAdmissionYear();
        }
    }

    public void setAdmissionYear(int admissionYear) {
        if (!isTeacher) {
            studentEntity.setAdmissionYear(admissionYear);
        }
    }

}
