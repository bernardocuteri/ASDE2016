package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2454592615243640364L;

	
	public Student() {
	}
	
	public Student(String name, String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String surname;
	
	@OneToMany(mappedBy="student")	
	private List<Exam> exams=new ArrayList<Exam>();
	
	@ManyToMany(mappedBy="students")
	private List<AcademicCourse> attendingCourses;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public List<Exam> getExams() {
		return exams;
	}
	
	
}
