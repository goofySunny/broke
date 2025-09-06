/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.model;

/**
 *
 * @author sun
 */
public class Expense {
    
    private long id;
    private double amount;
    private String description;
    private ExpenseType expenseType;
    private Person person;

    public Expense(long id, double amount, String description, ExpenseType expenseType, Person person) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.expenseType = expenseType;
        this.person = person;
    }

    public Expense(double amount, String description, ExpenseType expenseType, Person person) {
        this.amount = amount;
        this.description = description;
        this.expenseType = expenseType;
        this.person = person;
    }
    
    public Expense(double amount, String description, ExpenseType expenseType) {
        this.amount = amount;
        this.description = description;
        this.expenseType = expenseType;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public Person getPerson() {
        return person;
    }
}
