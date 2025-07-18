package ir.najaftech.services;

import ir.najaftech.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface ContactRepositoryService {

    List<Person> getAllPeople() throws Exception;

    Person getPersonById(long id) throws Exception;

    boolean writePerson(Person person) throws SQLException;
}
