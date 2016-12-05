package persistence;

import java.util.List;

import model.Exam;
import model.Student;

public interface StudentDAO {
	
	public void create(Student student);
	
	public List<Exam> getExams(Student student);
	
	public Student getById(int id);

}
