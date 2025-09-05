/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ir.najaftech.services;

import ir.najaftech.model.Expense;
import java.util.List;

/**
 *
 * @author sun
 */
public interface ExpenseRepositoryService {
    
    boolean save(Expense expense);
    
    List<Expense> getAll();
    
    Expense getById(long id);
    
    boolean update(long id, Expense expense);
    
    boolean deleteById(long id);
    
}
