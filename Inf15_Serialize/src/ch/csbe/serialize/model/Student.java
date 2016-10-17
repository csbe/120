package ch.csbe.serialize.model;

import java.io.Serializable;

public class Student implements Serializable{

	private String name;
	private float points;
	private float note;

	public Student(String name, float points) {
		super();
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
	
	public float getNote(){
		return note;
	}
	
	public void setNote(float maxpoints){
		this.note = points/maxpoints*5+1;
	}
	
}
