package ir.najaftech.gui;

import ir.najaftech.model.ExpenseCategory;

import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

public class ExpenseAdditionForm extends JPanel {

    JTextField expenseAmount;
    JTextField expenseDescription;
    JComboBox<ExpenseCategory> expenseCategory;
    JTextField customCategoryField;

    public ExpenseAdditionForm() {
        super();

//        Set up sub components
        expenseAmount = new JTextField(10);

        expenseDescription = new JTextField(10);

        customCategoryField = new JTextField(10);
        customCategoryField.setEnabled(false);

        DefaultComboBoxModel<ExpenseCategory> comboModel = new DefaultComboBoxModel<ExpenseCategory>();
        EnumSet.allOf(ExpenseCategory.class).forEach(comboModel::addElement);

        expenseCategory = new JComboBox<>();
        expenseCategory.setModel(comboModel);
        expenseCategory.addActionListener(e -> {
            if (expenseCategory.getSelectedItem() == ExpenseCategory.OTHER) {
                this.customCategoryField.setEnabled(true);
            } else {
                this.customCategoryField.setText("");
                this.customCategoryField.setEnabled(false);
            }
        });

//        Set up self
        this.setPreferredSize(new Dimension(350, 500));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setLayout(new GridBagLayout());

        this.setVisible(true);

//        Layout

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.fill = GridBagConstraints.HORIZONTAL;
//        First Row
//        Label
        add(new JLabel("Expense Amount: "), gc);

//        Control
        gc.gridx = 1;
        add(expenseAmount, gc);

//        Next Row
        gc.gridy++;
        gc.gridx = 0;

//        Label
        add(new JLabel("Description: "), gc);

//        Control
        gc.gridx = 1;
        add(expenseDescription, gc);

//        Next Row
        gc.gridy++;
        gc.gridx = 0;

//        Label
        add(new JLabel("Type: "), gc);

//        Control
        gc.gridx = 1;
        add(expenseCategory, gc);

//        Next Row
        gc.gridy++;
        gc.gridx = 0;

//        Label
        add(new JLabel("Custom Category: "), gc);

//        Control
        gc.gridx = 1;
        add(customCategoryField, gc);

//        OK
        gc.gridy++;
        gc.gridx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JButton("Add"), gc);
    }

}
