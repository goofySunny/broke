/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.services;

import ir.najaftech.model.Expense;
import ir.najaftech.model.ExpenseType;
import ir.najaftech.model.Person;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author sun
 */
public class ExpenseRepositoryServiceImpl implements ExpenseRepositoryService {

    private final ContactRepositoryService contactRepo;
    private final String url = "jdbc:sqlite:data.db";
    private Connection connection;

    public ExpenseRepositoryServiceImpl() {
        contactRepo = new ContactRepositoryServiceImpl();
        try {
            connection = initConnection(connection);
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS expenses(id BIGINT PRIMARY KEY, description TEXT, expense_type VARCHAR(255) NOT NULL, amount BIGINT, person_id BIGINT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(Expense expense) {
        try {
            connection = initConnection(connection);
            if (expense.getPerson() != null) {
                PreparedStatement prepare = connection.prepareStatement("INSERT INTO expenses (description, expense_type, amount, person_id) VALUES(?,?,?,?)");
                prepare.setString(1, expense.getDescription());
                prepare.setString(2, expense.getExpenseType().name());
                prepare.setBigDecimal(3, BigDecimal.valueOf(expense.getAmount()));
                prepare.setBigDecimal(4, BigDecimal.valueOf(expense.getPerson().getId()));
                prepare.execute();
                return true;
            } else {
                PreparedStatement prepare = connection.prepareStatement("INSERT INTO expenses (description, expense_type, amount) VALUES(?,?,?)");
                prepare.setString(1, expense.getDescription());
                prepare.setString(2, expense.getExpenseType().name());
                prepare.setBigDecimal(3, BigDecimal.valueOf(expense.getAmount()));
                prepare.execute();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Expense> getAll() {
        List<Expense> expenses = new ArrayList<>();

        try {
            connection = initConnection(connection);

            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM expenses");

            ResultSet res = prepare.executeQuery();

            while (res.next()) {
                expenses.add(mapObject(res));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expenses;
    }

    @Override
    public Optional<Expense> getById(long id) {
        Expense expense;

        try {
            connection = initConnection(connection);

            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM expenses WHERE id = ?");
            prepare.setLong(1, id);

            ResultSet res = prepare.executeQuery();

            if (res.next()) {
                if (!res.next()) {
                    return Optional.of(mapObject(res));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean update(long id, Expense expense) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection initConnection(Connection con) throws SQLException {
        try {
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Expense mapObject(ResultSet res) throws SQLException, Exception {

        String desc = res.getString("description");
        long amount = res.getLong("amount");
        Person person = contactRepo.getPersonById(res.getLong("person_id"));
        ExpenseType expenseType = ExpenseType.valueOf(res.getString("expense_type"));
        return new Expense(amount, desc, expenseType, person);
    }

}
