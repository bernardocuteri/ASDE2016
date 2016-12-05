package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Exam;
import model.Student;
import persistence.ExamDAO;
import persistence.ExamDAOImpl;
import persistence.StudentDAO;
import persistence.StudentDAOImpl;

public class ExamDAOTest {
	
	
	private static ExamDAO examsDao;
	private static StudentDAO studentsDAO;
	private static ArrayList<Exam> dbExams = new ArrayList<>();
	private static ArrayList<Student> students = new ArrayList<>();
	
	@BeforeClass
	public static void initialize() {
		examsDao = new ExamDAOImpl();
		studentsDAO = new StudentDAOImpl();
		for(int i=0;i<5;i++) {
			Student student = new Student("name"+i, "surname"+i);
			studentsDAO.create(student);
			students.add(student);
		}
		
		for(int i=0;i<10;i++) {
			Exam exam = new Exam("name"+i, 10, students.get(i/2),"professor Ricca", 30);
			examsDao.create(exam);
			dbExams.add(exam);
		}		
	}
	
	@Test
	public void testCreate() {
		Student john = new Student("John", "Doe");
		studentsDAO.create(john);
		Exam savingExam = new Exam("ASDE", 5, john, "professor Alviano", 30);
		examsDao.create(savingExam);
		assertEquals(examsDao.getExamByName("ASDE").getStudent().getName(), "John");
		examsDao.deleteExam(savingExam);
	}
	
	@Test
	public void testList() {
		assertEquals(examsDao.getExamsOfProfessor("professor Ricca").size(), 10);
	}
	
	@Test 
	public void testDelete() {
		examsDao.deleteExam(dbExams.get(0));
		assertEquals(examsDao.getExamsOfProfessor("professor Ricca").size(), 9);
		examsDao.create(dbExams.get(0));
	}
	
	@Test 
	public void testUpdate() {
		dbExams.get(0).setMark(18);
		examsDao.saveUpdates(dbExams.get(0));
		assertEquals(examsDao.getExamById(dbExams.get(0).getId()).getMark(), 18);
	}
	
	@Test
	public void testStudentRelation() {
		Student student1 = examsDao.getExamById(dbExams.get(0).getId()).getStudent();
		Student student2 = examsDao.getExamById(dbExams.get(1).getId()).getStudent();
		assert(student1.getId() == student2.getId());
		
	}
	
	@Test
	public void testGetStudentExams() {
		assert(studentsDAO.getExams(students.get(0)).size()==2);
	}
	
	@Test 
	public void testStudentExamList() {
		assert(studentsDAO.getById(students.get(0).getId()).getExams().size()==2);
	}
	
	
	

}
