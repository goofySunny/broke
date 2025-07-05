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
    Object[][] initialData = {{"Name", "Employment", "Gender", "local"}};

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
        add(table, BorderLayout.CENTER);
    }


    private void requestData() throws Exception {
        dataReadingService = new DataReadingServiceImpl();
        List<Person> people = dataReadingService.getAllPeople();

        for (Person p : people) {
            data = addEntry(data, p);
        }
    }

    public void refreshData() throws Exception {
        data = initialData;
        requestData();
//        TODO : actual refreshing business
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
