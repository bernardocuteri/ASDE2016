package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Exam;
import persistence.ExamDAO;
import persistence.ExamDAOImpl;

public class ExamDAOTest {
	
	
	private static ExamDAO dao;
	private static ArrayList<Exam> dbExams = new ArrayList<>();
	
	@BeforeClass
	public static void initialize() {
		dao = new ExamDAOImpl();
		for(int i=0;i<10;i++) {
			Exam exam = new Exam("name"+i, 10, "student"+i,"professor Ricca", 30);
			dao.create(exam);
			dbExams.add(exam);
		}		
	}
	
	@Test
	public void testCreate() {
		Exam savingExam = new Exam("ASDE", 5, "studente10", "professor Alviano", 30);
		dao.create(savingExam);
		assertEquals(dao.getExamByName("ASDE").getStudent(), "studente10");
		dao.deleteExam(savingExam);
	}
	
	@Test
	public void testList() {
		assertEquals(dao.getExamsOfProfessor("professor Ricca").size(), 10);
	}
	
	@Test 
	public void testDelete() {
		dao.deleteExam(dbExams.get(0));
		assertEquals(dao.getExamsOfProfessor("professor Ricca").size(), 9);
		dao.create(dbExams.get(0));
	}
	
	@Test 
	public void testUpdate() {
		dbExams.get(0).setMark(18);
		dao.saveUpdates(dbExams.get(0));
		assertEquals(dao.getExamById(dbExams.get(0).getId()).getMark(), 18);
	}

}
