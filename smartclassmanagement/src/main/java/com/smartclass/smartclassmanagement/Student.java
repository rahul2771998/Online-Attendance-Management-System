package com.smartclass.smartclassmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@Column(unique = true)
	public int scholar_no;
	
	@NotBlank(message="Should not be Blank")
	@Size(min=2,max=30,message="min 2 and max 30 characters are allow")
	public String name;
	public String email;
	public long  contact_no;
	@Override
	public String toString() {
		return "Student [scholar_no=" + scholar_no + ", name=" + name + ", email=" + email + ", contact_no="
				+ contact_no + ", password=" + password + ", about=" + about + "]";
	}
	public Student(int scholar_no,
			@NotBlank(message = "Should not be Blank") @Size(min = 2, max = 30, message = "min 2 and max 30 characters are allow") String name,
			String email, long contact_no, String password, String about) {
		super();
		this.scholar_no = scholar_no;
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
		this.password = password;
		this.about = about;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getScholar_no() {
		return scholar_no;
	}
	public void setScholar_no(int scholar_no) {
		this.scholar_no = scholar_no;
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
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	private String password;
	private String about;
	

}
