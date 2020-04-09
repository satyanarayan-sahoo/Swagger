package com.swagger2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger2.demo.model.Person;
import com.swagger2.demo.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}
	
	@Override
	public Person updatePerson(int id,Person person) {
		Person p = personRepo.getOne(id);
	    p.setName(person.getName());
		p.setAge(person.getAge());
		return personRepo.save(p);
	}
	
	@Override
	public Person getPerson(int id) {
		return personRepo.getOne(id);
	}

	@Override
	public void deletePerson(Person person) {
		personRepo.delete(person);
	}

	@Override
	public void deletePerson(int id) {
		personRepo.deleteById(id);
	}

	@Override
	public long countPersons() {
		return personRepo.count();
	}

	@Override
	public List<Person> findByPersonsAge(int age) {
		return personRepo.findByAge(age);
	}
	
	@Override
	public List<Person> findDetailsByName(String name) {
		return personRepo.findByName(name);
	}
	
	@Override
	public List<Person> retrieveByPersonName(String name) {
		return personRepo.retrieveByPersonName(name);
	}
}//class
