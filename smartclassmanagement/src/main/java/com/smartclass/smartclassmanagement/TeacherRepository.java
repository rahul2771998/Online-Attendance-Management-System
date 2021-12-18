package com.smartclass.smartclassmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
	@Query("select u from Teacher u where u.email = :email")
	public Teacher getTeacherByEamil(@Param("email") String email);

}
