package ir.najaftech.gui.Expenses;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ExpenseParentPanel extends JPanel {

    public ExpenseParentPanel() {
        JPanel expenseFormPanel = new JPanel();
        JPanel expenseListPanel = new JPanel();

        expenseFormPanel.add(new JLabel("Expense Amount"));
        expenseFormPanel.add(new JTextField(10));
        expenseFormPanel.add(new JLabel("Date of Expense"));

        this.add(expenseListPanel, BorderLayout.EAST);
        this.add(expenseFormPanel, BorderLayout.WEST);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }
}
