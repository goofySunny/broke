package ir.najaftech.gui;

import javax.swing.*;

public class CustomJTable extends JTable {

    public CustomJTable(Object[][] data, Object[] columns) {
        super(data, columns);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
