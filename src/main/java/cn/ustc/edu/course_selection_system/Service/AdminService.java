package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseinfoEntity;
import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import javafx.util.Pair;

import java.util.List;

public class AdminService {
    /**
     * 批量导入个人信息
     * @param infos 信息列表
     * @return 成功导入人数
     */
    public int ImportID(List<PersonInfo> infos){
        return 0;
    }

    /**
     * 批量导入课程信息
     * @param courseInfos 课程信息
     * @return 成功导入个数
     */
	public int ImportCourse(List<CourseinfoEntity> courseInfos){
        return 0;
    }

    /**
     * 导入学生-课程对
     * @param S_CList 学生-课程列表
     * @return 成功导入个数
     */
    public int ImportS_C(List<Pair<Integer,Integer>> S_CList){
        return 0;
    }

    /**
     * 导入教师-课程对
     * @param T_CList 教师-课程列表
     * @return 成功导入个数
     */
    public int ImportT_C(Pair<Integer,Integer> T_CList){
        return 0;
    }

    /**
     * 删除人员（包括关联键）
     * @param id_list 删除人员id名单
     * @return 成功删除个数
     */
    public int DelID(List<Integer> id_list){
        return 0;
    }

    /**
     * 删除课程（包括关联键）
     * @param id_list  删除课程id名单
     * @return 成功删除个数
     */
	public int DelCourse(List<Integer> id_list){
        return 0;
    }

    /**
     * 删除学生-课程对
     * @param S_CList 学生-课程对
     * @return 成功删除个数
     */
	public int DelS_C(Pair<Integer,Integer> S_CList){
        return 0;
    }

    /**
     * 删除教师-课程对
     * @param T_CList 教师-课程对
     * @return 成功删除个数
     */
    public int DelT_C(Pair<Integer,Integer> T_CList){
        return 0;
    }
}
