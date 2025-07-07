package ir.najaftech.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import ir.najaftech.model.Person;
import ir.najaftech.services.DataReadingService;
import ir.najaftech.services.DataReadingServiceImpl;

public class TextPanel extends JPanel {

    DataReadingService dataReadingService;
    Object[][] initialData;

    JTextArea textArea;
    Object[][] data = initialData;
    String[] columns = {"Name", "Employment", "Gender", "local"};

    CustomJTable table;
    
    public TextPanel() throws Exception {
        requestData();

        table = new CustomJTable(data, columns);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        setLayout(new BorderLayout());
        setVisible(true);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setPreferredSize(new Dimension(1000,1000));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }


    private void requestData() throws Exception {
        dataReadingService = new DataReadingServiceImpl();
        List<Person> people = dataReadingService.getAllPeople();

        for (Person p : people) {
            data = addEntry(data, p);
        }
    }

    public void refreshData() throws Exception {
        this.removeAll();
        data = initialData;
        requestData();
        table = new CustomJTable(data, columns);
        this.repaint();
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.revalidate();
    }

    private Object[][] addEntry(Object[][] originalArray, Person newEntry) {

        if (originalArray == null) {
            return new Object[][]{{
                newEntry.getName(),
                newEntry.getEmploymentStatus().toString(),
                newEntry.getGender().toString(),
                newEntry.isLocal() ? "YES" : "NO"
            }};
        }
        Object[][] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);


        Object[] newRow = Arrays.copyOf(columns, columns.length);
        newArray[newArray.length-1] = newRow;

        newRow[0] = newEntry.getName();
        newRow[1] = newEntry.getEmploymentStatus().toString();
        newRow[2] = newEntry.getGender().toString();
        newRow[3] = newEntry.isLocal() ? "YES" : "NO";

        return newArray;
    }

}
