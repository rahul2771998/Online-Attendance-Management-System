package com.smartclass.smartclassmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	private long teacher_id;
	private String name;
	private String email;
	private String subject;
	private long  contact_no;
	private String about;
	private String password;
	
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", name=" + name + ", email=" + email + ", subject=" + subject
				+ ", contact_no=" + contact_no + ", about=" + about + ", password=" + password + "]";
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(long teacher_id, String name, String email, String subject, long contact_no, String about,
			String password) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.contact_no = contact_no;
		this.about = about;
		this.password = password;
	}
	public long getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
