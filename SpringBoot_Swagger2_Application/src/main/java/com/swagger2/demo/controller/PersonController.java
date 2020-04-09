package com.swagger2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger2.demo.model.Person;
import com.swagger2.demo.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "REST Apis related to Person Entity!!!!")
@RestController
@RequestMapping(value = "/person",produces = MediaType.APPLICATION_JSON_VALUE)
class PersonController {
	
	@Autowired
	private PersonService personService;
	
	/* POST
	 * http://localhost:9437/swagger2-demo/person/addPerson
	 * {
	    "name":"Raja Babu",
	    "age":"23"
       }*/
	@PostMapping(value = "/addPerson")
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/persons
	 * */
	@GetMapping(value = "/persons")
	public List<Person> findAllPerson() {
		return personService.getAllPersons();
	}
	
	/* PUT
	 * http://localhost:9437/swagger2-demo/person/updateDetails/43
	 * {
	       "name":"Laxmidhar Rout",
	       "age":"24"
       }
    */
	@PutMapping(value = "/updateDetails/{id}")
	public Person updatePersonDetails(@PathVariable int id,@RequestBody Person person) {
		return personService.updatePerson(id,person);
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/getPerson/41
	 *  */
	@GetMapping(value = "/getPerson/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	/* DELETE
	 * http://localhost:9437/swagger2-demo/person/deletePerson
	   {
         "id": 41,
         "name": "Raja Babu",
         "age": 23
       }
	 * */
	@DeleteMapping(value = "/deletePerson")
	public void deletePerson(@RequestBody Person person) {
		personService.deletePerson(person);
	}
	
	/* DELETE
	 * http://localhost:9437/swagger2-demo/person/deletePerson/42
	 * */
	@DeleteMapping(value = "/deletePerson/{id}")
	public void deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/countPersons 
	 * */
	@GetMapping(value = "/countPersons")
	public long countPersons() {
		return personService.countPersons();
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/findPerson/23
	 * */
	@GetMapping(value = "/findPerson/{age}")
	public List<Person> findPersonByAge(@PathVariable int age){
		return personService.findByPersonsAge(age);
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/findDetails/Raja Babu
	 * */
	@GetMapping(value = "/findDetails/{name}")
	public List<Person> findDetailsByName(@PathVariable String name){
		return personService.findDetailsByName(name);
	}
	
	/* GET
	 * http://localhost:9437/swagger2-demo/person/retrieveByPersonName/Raja Babu
	 * */
	@GetMapping(value = "/retrieveByPersonName/{name}")
	public List<Person> retrieveByPersonName(@PathVariable String name){
		return personService.retrieveByPersonName(name);
	}
	
}//class
