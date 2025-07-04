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

    JTextArea textArea;
    Object[][] data = {{"Name", "Employment", "Gender", "local"}};

    CustomJTable table;
    
    public TextPanel() throws Exception {
        dataReadingService = new DataReadingServiceImpl();
        List<Person> people = initializeTableData();

        for (Person p : people) {
            data = addEntry(data, p);
        }

        String[] columns = {"Name", "Employment", "Gender", "local"};
        table = new CustomJTable(data, columns);
        setLayout(new BorderLayout());
        setVisible(true);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setPreferredSize(new Dimension(1000,1000));
        add(table, BorderLayout.CENTER);
    }

    public void appendPerson(Person p) {
    }

    private List<Person> initializeTableData() throws Exception {
        return dataReadingService.getAllPeople();
    }

    private Object[][] addEntry(Object[][] originalArray, Person newEntry) {

        Object[][] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);


        Object[] newRow = Arrays.copyOf(newArray[0], newArray[0].length);
        newArray[newArray.length-1] = newRow;

        newRow[0] = newEntry.getName();
        newRow[1] = newEntry.getEmploymentStatus();
        newRow[2] = newEntry.getGender();
        newRow[3] = newEntry.isLocal();

        return newArray;
    }

}
