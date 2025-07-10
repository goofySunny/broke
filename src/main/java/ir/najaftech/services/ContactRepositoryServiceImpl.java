package ir.najaftech.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ir.najaftech.model.EmploymentStatus;
import ir.najaftech.model.Gender;
import ir.najaftech.model.Person;
import org.sqlite.SQLiteException;


public class ContactRepositoryServiceImpl implements ContactRepositoryService {
	
	private final String url = "jdbc:sqlite:data.db";
    private Connection connection;

//	Query ALL from person table and instantiate new Person Objects for each row 
	@Override
	public List<Person> getAllPeople() throws Exception {
    
		List<Person> people = new ArrayList<>();
		

        connection = DriverManager.getConnection(url);
        
        Statement statement = connection.createStatement();
        
        String prepare = "SELECT * FROM person";
		ResultSet res;
		try {
			res = statement.executeQuery(prepare);
		} catch (SQLiteException e) {
			createTable();
			res= statement.executeQuery(prepare);
		}
		while(res.next()) {

		EmploymentStatus empStatus = iterateThroughEnum(res.getString("employment_status"), EmploymentStatus.class);
		Gender gen = iterateThroughEnum(res.getString("gender"), Gender.class);

		String nationalNum = res.getString("national_number") != null ? res.getString("national_number") : "";

		Person person = new Person(res.getLong("id"), res.getString("name"), empStatus, gen, nationalNum);

		people.add(person);

	}
        
        statement.close();
        connection.close();
        
        return people;
	}

//	Find only one person by their id
	@Override
	public Person getPersonById(long id) throws Exception {
		
		Person person;

		connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String prepare = "SELECT * FROM person WHERE id = " + id;

		ResultSet res = statement.executeQuery(prepare);
		res.next();

		String nationalNum = res.getString("national_number") != null ? res.getString("national_number") : "";

		EmploymentStatus empStatus = iterateThroughEnum(res.getString("employment_status"), EmploymentStatus.class);
		Gender gen = iterateThroughEnum(res.getString("gender"), Gender.class);

		res.getLong("id");
		res.getString("name");

		person = new Person(res.getLong("id"), res.getString("name"), empStatus, gen, nationalNum);

//			If there is more rows returned throw Exception
		if (res.next()) {
				throw new Exception();
		}

		statement.close();
		connection.close();

		return person;
	}

	@Override
	public boolean writePerson(Person person) throws SQLException {

		connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO person(name, employment_status, local, gender, national_number) VALUES" +
				"('" +
				person.getName() +
				"','" +
				person.getEmploymentStatus() +
				"'," +
				person.isLocal() +
				",'" +
				person.getGender() +
				"','" +
				person.getNationalnumber() +
				"')";

		int affectedRows = statement.executeUpdate(sql);

		return affectedRows > 0;
	}

//	Table Initialization
	private void createTable() throws SQLException {
		Connection connection = DriverManager.getConnection(url);
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE TABLE person(id INTEGER PRIMARY KEY UNIQUE, name VARCHAR(255) NOT NULL, employment_status VARCHAR(255) NOT NULL, gender VARCHAR(7) NOT NULL," +
				"local BOOLEAN NOT NULL, national_number VARCHAR(255))");
		stmt.close();
		connection.close();
	}

	private <E extends Enum<?>> E iterateThroughEnum(String text, Class<E> enumeratedValue) {

		for (E e: enumeratedValue.getEnumConstants()) {
			if (text.equalsIgnoreCase(e.toString())) {
				return e;
			}
		}
		return null;
	}

}










