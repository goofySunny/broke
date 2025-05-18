package ir.najaftech.gui;

import ir.najaftech.model.Expense;
import ir.najaftech.model.ExpenseCategory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {

//    Members
    ArrayList<Expense> expenses;
    JList<Expense> expenseJList;
    DefaultListModel<Expense> listModel;
//    Members

    public GraphPanel(ArrayList<Expense> expenses) {
        super();
        this.expenses = expenses;
        expenses.add(new Expense(200, "Ayo", ExpenseCategory.DEBT, ""));

//        Set up sub components
        listModel = new DefaultListModel<>();
        expenses.forEach(listModel::addElement);

        expenseJList = new JList<>();
        expenseJList.setModel(listModel);


        add(expenseJList);
//        Set up self
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(350, 500));
        setVisible(true);
    }

    void addExpense(Expense e) {
        listModel.addElement(e);
    }
}
