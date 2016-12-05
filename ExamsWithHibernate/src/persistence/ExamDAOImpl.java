package persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Exam;
import persistence.DBHandler.Operation;

public class ExamDAOImpl implements ExamDAO {
	
	
	public ExamDAOImpl() {
		
	}

	@Override
	public void create(Exam exam) {
		DBHandler.getInstance().performOperation(exam, Operation.SAVE);
	}

	@Override
	public Exam getExamById(int id) {
		
		Session session = DBHandler.getInstance().openSession();
		Exam exam = (Exam)session.createSQLQuery("SELECT * FROM exam WHERE id="+id).addEntity(Exam.class).uniqueResult();
		session.close();
		return exam;
		
	}

	@Override
	public Exam getExamByName(String name) {

		Session session = DBHandler.getInstance().openSession();
		Exam exam = (Exam)session.createSQLQuery("SELECT * FROM exam WHERE name='"+name+"'").addEntity(Exam.class).uniqueResult();
		session.close();
		return exam;
	}

	@Override
	@SuppressWarnings(value="unchecked")
	public List<Exam> getExamsOfProfessor(String professor) {
		Session session = DBHandler.getInstance().openSession();
		List<Exam> result = (List<Exam>) session.createSQLQuery("SELECT * FROM exam WHERE professor='"+professor+"'").addEntity(Exam.class).list();
		session.close();
		return result;
	}

	@Override
	public void saveUpdates(Exam exam) {
		DBHandler.getInstance().performOperation(exam, Operation.UPDATE);
	}

	@Override
	public void deleteExam(Exam exam) {
		DBHandler.getInstance().performOperation(exam, Operation.DELETE);
	}
}
