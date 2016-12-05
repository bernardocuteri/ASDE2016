package persistence;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import model.Exam;
import model.Student;
import persistence.DBHandler.Operation;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void create(Student student) {
		DBHandler.getInstance().performOperation(student, Operation.SAVE);
	}

	@Override
	@SuppressWarnings(value="unchecked")
	public List<Exam> getExams(Student student) {
		Session session = DBHandler.getInstance().openSession();
		List<Exam> result = session.createSQLQuery("select * from exam where student="+student.getId()).addEntity(Exam.class).list();
		session.close();
		return result;
	}
	
	@Override
	public Student getById(int id) {
		Session session = DBHandler.getInstance().openSession();
		Student result = (Student) session.createSQLQuery("select * from student where id="+id).addEntity(Student.class).uniqueResult();
		//result.getExams().size();
		Hibernate.initialize(result.getExams());
		session.close();
		return result;
	}
}
