package com.smartclass.smartclassmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int scholar_no;
	private int subject_id;
	private int count;
	private int total_lecture;
	private String status;
	public int getId() {
		return id;
	}
	public Attendance(int id, int scholar_no, int subject_id, int count, int total_lecture, String status) {
		super();
		this.id = id;
		this.scholar_no = scholar_no;
		this.subject_id = subject_id;
		this.count = count;
		this.total_lecture = total_lecture;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScholar_no() {
		return scholar_no;
	}
	public void setScholar_no(int scholar_no) {
		this.scholar_no = scholar_no;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal_lecture() {
		return total_lecture;
	}
	public void setTotal_lecture(int total_lecture) {
		this.total_lecture = total_lecture;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendance(int id, int scholar_no, int subject_id, int count, int total_lecture) {
		super();
		this.id = id;
		this.scholar_no = scholar_no;
		this.subject_id = subject_id;
		this.count = count;
		this.total_lecture = total_lecture;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", scholar_no=" + scholar_no + ", subject_id=" + subject_id + ", count=" + count
				+ ", total_lecture=" + total_lecture + ", status=" + status + "]";
	}
	


}
