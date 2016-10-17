package ch.csbe.serialize;

import java.util.ArrayList;
import java.util.List;

import ch.csbe.serialize.helper.SerializeIO;
import ch.csbe.serialize.model.Exam;
import ch.csbe.serialize.model.Student;

public class SerializeApp {

	public static void main(String[] args) {
		/*
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Buchs", 22f));
		students.add(new Student("Muster", 28f));
		
		Exam e = new Exam(120, "lb1", 30);
		e.setStudents(students);
		e.setNoten();	
		
		SerializeIO.save(e);
		*/
		Exam fromFile = SerializeIO.load("lb1");
		
		for(Student s : fromFile.getStudents()){
			System.out.println(s.getName() + " " + s.getNote());
		}
		
		
	}

}
