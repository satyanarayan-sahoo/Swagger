package com.swagger2.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swagger2.demo.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	public List<Person> findByName(String name);
	
	public List<Person> findByAge(int age); 
	
	@Query("SELECT p FROM Person p WHERE p.name=:name")
	public List<Person> retrieveByPersonName(@Param("name") String name);
}
