package ch.csbe.serialize.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exam implements Serializable {

	private int nr;
	private String name;
	private int points;
	private List<Student> students = new ArrayList<Student>();

	public Exam(int nr, String name, int points) {
		super();
		this.nr = nr;
		this.name = name;
		this.points = points;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void setNoten(){
		for(Student s : students){
			s.setNote(points);
		}
	}

}
