package cn.ustc.edu.course_selection_system.Service;

import cn.ustc.edu.course_selection_system.Bean.CourseInfo;
import cn.ustc.edu.course_selection_system.Bean.PersonInfo;
import javafx.util.Pair;

import java.util.List;

public class AdminService {
    public int ImportID(List<PersonInfo> infos){
        return 0;
    }

	public int ImportCourse(List<CourseInfo> courseInfos){
        return 0;
    }
    public int ImportS_C(List<Pair<Integer,Integer>> S_C){
        return 0;
    }
    public int ImportT_C(Pair<Integer,Integer> T_C){
        return 0;
    }
    public int DelID(List<Integer> idlist){
        return 0;
    }
	public int DelCourse(List<Integer> id_list){
        return 0;
    }
	public int DelS_C(Pair<Integer,Integer> S_C){
        return 0;
    }
    public int DelT_C(Pair<Integer,Integer> T_C){
        return 0;
    }
}
