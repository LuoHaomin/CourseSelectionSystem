package cn.ustc.edu.course_selection_system.Database;

import cn.ustc.edu.course_selection_system.Bean.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentImpl implements Person {
    static Session session;
    static Transaction transaction;

    private void StartSession(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
        } catch (HibernateException e) {
//            e.printStackTrace();
            transaction.rollback();
            System.out.println("Failed to start a session!");
        }
    }

    private void CloseSession(){
        try {
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
//            e.printStackTrace();
            transaction.rollback();
            System.out.println("Failed to close a session!");
        }
    }

    @Override
    public void AddCoursePair() {
        StartSession();
        StudentEntity student = new StudentEntity();
    }

    @Override
    public void DeleteCoursePair() {

    }

    @Override
    public void GetChosenCourseList(int id) {
        StartSession();
        StudentEntity student = session.get(StudentEntity.class, id);

    }

    public void GetStudentScore(int id){

    }

    public void ImportScore(){
        //TODO:what parameters to feed?
    }

    public void ChangeScore(int id, String score){

    }
}
