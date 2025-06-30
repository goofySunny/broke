package ir.najaftech.services;

import java.util.List;

import ir.najaftech.model.Person;

public interface DataReadingService {
	
	List<Person> getAllPeople() throws Exception;
	
	Person getPersonById(long id) throws Exception;
}
