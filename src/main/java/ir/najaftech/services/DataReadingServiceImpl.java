package ir.najaftech.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ir.najaftech.model.EmploymentStatus;
import ir.najaftech.model.Gender;
import ir.najaftech.model.Person;


public class DataReadingServiceImpl implements DataReadingService {
	
	private final String url = "jdbc:sqlite:data.db";
    private Connection connection;

//	Query ALL from person table and instantiate new Person Objects for each row 
	@Override
	public List<Person> getAllPeople() throws Exception {
    
		List<Person> people = new ArrayList<Person>();
		

        try {
        connection = DriverManager.getConnection(url);
        
        Statement statement = connection.createStatement();
        
        String prepare = "SELECT * FROM person";
        ResultSet res = statement.executeQuery(prepare);
        while(res.next()) {
        	
        	EmploymentStatus empStatus = null;
        	Gender gen = null;
        	
//        	Find Correct Enum
        	for (EmploymentStatus emp : EmploymentStatus.values()) {
        		if (res.getString("employment_status").equalsIgnoreCase(emp.toString())) {
        			empStatus = emp;
        			break;
        		}    		
        	}
        	
//        	Find Correct Enum        	
        	for (Gender sex : Gender.values()) {
        		if (res.getString("gender").equalsIgnoreCase(sex.toString())) {
        			gen = sex;
        			break;
        		}
        	}
        	
        	String nationalNum = res.getString("national_number") != null ? res.getString("national_number") : "";
        	
        	Person person = new Person(res.getLong("id"), res.getString("name"), empStatus, gen, nationalNum);
        	
        	people.add(person);
        	
        }
        
        statement.close();
        connection.close();
        } catch (Exception e) {
        	e.printStackTrace();
            throw new Exception("Failed to Contact to database please try again");
        }
        
        return people;
	}

//	Find only one person by their id
	@Override
	public Person getPersonById(long id) throws Exception {
		
		Person person;
		
		try {
			connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			String prepare = "SELECT * FROM person WHERE id = " + id;
			
			ResultSet res = statement.executeQuery(prepare); 
			res.next();

			String nationalNum = res.getString("national_number") != null ? res.getString("national_number") : "";
			EmploymentStatus empStatus = null;
			Gender gen = null;
			
//        	Find Correct Enum
        	for (EmploymentStatus emp : EmploymentStatus.values()) {
        		if (res.getString("employment_status").equalsIgnoreCase(emp.toString())) {
        			empStatus = emp;
        			break;
        		}    		
        	}
        	
//        	Find Correct Enum        	
        	for (Gender sex : Gender.values()) {
        		if (res.getString("gender").equalsIgnoreCase(sex.toString())) {
        			gen = sex;
        			break;
        		}
        	}
			
			res.getLong("id");
			res.getString("name");
			
			person = new Person(res.getLong("id"), res.getString("name"), empStatus, gen, nationalNum);
			
//			If there is more rows returned throw Exception
			if (res.next()) {
				throw new Exception();
			}
			
			statement.close();
			connection.close();
		} catch(Exception ex) {
			ex.printStackTrace();
            throw new Exception(ex.getMessage());
		}
		
		return person;
	}
	
//	TODO : extract the repetetive code into a method

}










