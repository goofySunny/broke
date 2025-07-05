package ir.najaftech.services;

import ir.najaftech.model.Person;

import java.sql.SQLException;

public interface DataWritingService {

	boolean writePerson(Person person) throws SQLException;
}
