package com.smartclass.smartclassmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int subject_id;
	private String subject_name;
	private String active;
	private int total_lecture ;
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", subject_name=" + subject_name + ", active=" + active
				+ ", total_lecture=" + total_lecture + "]";
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int subject_id, String subject_name, String active, int total_lecture) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.active = active;
		this.total_lecture = total_lecture;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public int getTotal_lecture() {
		return total_lecture;
	}
	public void setTotal_lecture(int total_lecture) {
		this.total_lecture = total_lecture;
	}
	

}
