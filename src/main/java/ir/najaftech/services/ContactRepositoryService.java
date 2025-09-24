package ir.najaftech.services;

import ir.najaftech.model.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author sun
 */

public interface ContactRepositoryService {

    List<Person> getAllPeople() throws Exception;

    Person getPersonById(long id) throws Exception;
    
    Optional<Person> getPersonByName(String name);

    boolean writePerson(Person person) throws SQLException;
    
    boolean deletePersonById(int id);
    
    boolean updatePerson(Person person);
}
