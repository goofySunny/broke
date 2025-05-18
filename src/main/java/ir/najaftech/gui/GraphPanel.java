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
    JLabel expenseCounter;
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

        expenseCounter = new JLabel("Current expense count: " + expenses.size());

//        add(expenseJList);
//        Set up self
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(350, 500));

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.3;
        gc.weighty = 0.3;

//        First Row
        gc.anchor = GridBagConstraints.LINE_START;
        add(expenseCounter, gc);


        setVisible(true);
    }

    void addExpense(Expense e) {
        expenses.add(e);
        listModel.addElement(e);
        expenseCounter.setText("Current expense count: " + expenses.size());
    }
}
