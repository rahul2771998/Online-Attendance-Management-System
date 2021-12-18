package com.smartclass.smartclassmanagement;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	@Query("select a from Attendance a where a.subject_id= :subject_id and a.scholar_no= :scholar_no ")
	public Attendance getAttendanceBySubjectIdAndScholarNo(@Param("subject_id") int subject_id,@Param("scholar_no") int scholar_no);
	
	/*@Query("select a.total_lecture from attendance a where  a.scholar_no=1 and a.subject_id= :subject_id ")
	public int getTotalLecture(@Param("subject_id") int subject_id );*/
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update  Attendance a  set   a.status= :status where a.subject_id= :subject_id ")
	public void updateStatus(@Param("subject_id") int subject_id, @Param("status") String status);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update  Attendance a  set   a.total_lecture= :total_lecture where a.subject_id= :subject_id ")
	public void updateLecture(@Param("subject_id") int subject_id, @Param("total_lecture") int total_lecture);
	
	

	

	

}
