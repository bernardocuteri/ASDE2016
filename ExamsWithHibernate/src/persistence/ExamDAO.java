package persistence;

import java.util.List;

import model.Exam;

public interface ExamDAO {
	
	public void create(Exam exam);
	
	public Exam getExamById(int id);
	
	public Exam getExamByName(String name);
	
	public List<Exam> getExamsOfProfessor(String professor);
	
	public void saveUpdates(Exam exam);
	
	public void deleteExam(Exam exam);
	
}
