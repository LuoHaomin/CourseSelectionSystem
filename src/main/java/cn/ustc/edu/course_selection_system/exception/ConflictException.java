package cn.ustc.edu.course_selection_system.exception;

/**
 * 冲突异常
 */
public class ConflictException extends Exception{
    public ConflictException(Boolean isConflict) {
        super("该时间安排冲突！");
    }
}
