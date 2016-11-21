package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788958460101795241L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	@Column(nullable=false, length=50, unique=true)
	private String name;
	@Column(nullable=false)
	private int credits;
	@Column(nullable=false)
	private String student;
	@Column(nullable=false)
	private String professor;
	@Column(nullable=false)
	private int mark;
	
	public Exam() {
	}
	
	
	
	public Exam(String name, int credits, String student, String professor, int mark) {
		super();
		this.name = name;
		this.credits = credits;
		this.student = student;
		this.professor = professor;
		this.mark = mark;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	
}
