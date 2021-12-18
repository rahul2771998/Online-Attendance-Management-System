package com.smartclass.smartclassmanagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<Student,Integer>{
	@Query("select u from Student u where u.email = :email")
	public Student getUserByEmail(@Param("email") String email);
	
	

}

