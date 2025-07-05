package ir.najaftech.services;

import ir.najaftech.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataWritingServiceImpl implements DataWritingService {

    private final String url = "jdbc:sqlite:data.db";
    private Connection connection;

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

}
