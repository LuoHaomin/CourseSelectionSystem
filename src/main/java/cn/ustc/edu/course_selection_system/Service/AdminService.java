package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.*;
import cn.ustc.edu.course_selection_system.Database.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    /**
     * 批量导入学生信息
     * @param infos 信息列表
     * @return 成功导入人数
     */
    public int ImportStudentID(List<StudentEntity> infos){
        StudentImpl studentImpl = new StudentImpl();
        for(StudentEntity info : infos){
            studentImpl.addStudent(info);
        }
        return infos.size();
    }

    /**
     * 批量导入教师信息
     * @param infos 教师信息
     * @return 成功导入人数
     */
    public int ImportTeacherID(List<TeacherEntity> infos){
        TeacherImpl teacherImpl = new TeacherImpl();
        for(TeacherEntity info : infos){
            teacherImpl.addTeacher(info);
        }
        return infos.size();
    }

    /**
     * 批量导入课程信息
     * @param courseInfos 课程信息
     * @return 成功导入个数
     */
	public int ImportCourse(List<CourseInfo> courseInfos) {
        CourseImpl courseImpl = new CourseImpl();
        TeacherCourse teacherCourse = new TeacherCourse();
        for(CourseInfo info : courseInfos){
            int courseId = courseImpl.AddCourse(info.getCourseEntity());
            for(TeacherEntity teacher : info.getTeacherEntity()){
                teacherCourse.AddCoursePair(teacher.getId(),courseId);
            }
        }
        return courseInfos.size();
    }


    /**
     * 导入学生-课程对
     * @param S_CList 学生-课程列表
     * @return 成功导入个数
     */
    public int ImportS_C(List<Pair<String,Integer>> S_CList){
        StudentCourse studentCourse = new StudentCourse();
        for(Pair<String,Integer> info : S_CList){
            studentCourse.AddCoursePair(info.getKey(), info.getValue());
        }
        return 0;
    }

    /**
     * 导入教师-课程对
     * @param T_CList 教师-课程列表
     * @return 成功导入个数
     */
    public int ImportT_C(List<Pair<String,Integer>> T_CList){
        TeacherCourse teacherCourse = new TeacherCourse();
        for(Pair<String,Integer> info : T_CList){
            teacherCourse.AddCoursePair(info.getKey(),info.getValue());
        }
        return 0;
    }

    /**
     * 删除人员（包括关联键）
     * @param personInfoList 删除人员id名单
     * @return 成功删除个数
     */
    public static int DelID(List<PersonInfo> personInfoList){
        for(PersonInfo personInfo : personInfoList){
            boolean isTeacher = personInfo.isTeacher();
            if(isTeacher){
                TeacherImpl teacherImpl = new TeacherImpl();
                teacherImpl.deleteTeacher(personInfo.getId());
            }
            else {
                StudentImpl studentImpl = new StudentImpl();
                studentImpl.deleteStudent(personInfo.getId());
            }
        }
        return 0;
    }

    /**
     * 删除课程（包括关联键）
     * @param courseInfoList 删除课程id名单
     */
	public static void DelCourse(List<CourseInfo> courseInfoList){
        CourseImpl courseImpl = new CourseImpl();
        for (CourseInfo courseInfo : courseInfoList){
            courseImpl.DeleteCourse(courseInfo.getCourseEntity().getId());
        }
    }


    /**
     * 删除教师-课程对
     * @param T_CList 教师-课程对
     * @return 成功删除个数
     */
    @Deprecated
    public int DelT_C(Pair<Integer,Integer> T_CList){
        return 0;
    }

    public static Long getNumOfStuByCons(String major, String admissionYear){
        StudentImpl studentImpl = new StudentImpl();
        return studentImpl.NumberInConstraint("%",major,admissionYear);
    }

    public static List<PersonInfo> getPersonInfo(String major, String admissionYear,Integer page,Integer pageSize){
        StudentImpl studentImpl = new StudentImpl();
        List<PersonInfo> personInfos = new ArrayList<>();
        List<StudentEntity> studentEntities = studentImpl.FindWithConstraint("%",major,admissionYear,page,pageSize);
        for(StudentEntity studentEntity : studentEntities){
            personInfos.add(new PersonInfo(studentEntity));
        }
        return personInfos;
    }

    public static List<PersonInfo> getPersonInfo(String Id){
        StudentImpl studentImpl = new StudentImpl();
        TeacherImpl teacherImpl = new TeacherImpl();
        List<PersonInfo> personInfos = new ArrayList<>();

        try {
            StudentEntity student = studentImpl.getStudent(Id);
            TeacherEntity teacher = teacherImpl.getTeacher(Id);

            if(student!=null){
                personInfos.add(new PersonInfo(student));
            }

            if(teacher!=null){
                personInfos.add(new PersonInfo(teacher));
            }
        } catch (Exception ignored) {}

        List<StudentEntity> studentEntities = studentImpl.FindWithConstraint(Id,"%","%");
        for(StudentEntity studentEntity : studentEntities){
            personInfos.add(new PersonInfo(studentEntity));
        }
        List<TeacherEntity> teacherEntities = teacherImpl.FindWithConstraint(Id) ;

        for(TeacherEntity teacherEntity : teacherEntities){
            personInfos.add(new PersonInfo(teacherEntity));
        }
        return personInfos;
    }
}
