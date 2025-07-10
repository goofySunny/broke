package ir.najaftech.gui.Contacts;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import ir.najaftech.model.Person;
import ir.najaftech.services.DataReadingService;
import ir.najaftech.services.DataReadingServiceImpl;

public class ContactListPanel extends JPanel {

    DataReadingService dataReadingService;

    private final Object[][] placeHolderData = {{"Example", "???", "???", "???"}};
    private final String[] columns = {"Name", "Employment", "Gender", "local"};


    Object[][] data;
    CustomJTable table;
    
    public ContactListPanel() throws Exception {
        requestData();

        if (data == null) {
            data = placeHolderData;
        }

        table = new CustomJTable(data, columns);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        setLayout(new GridBagLayout());
        setVisible(true);
        setPreferredSize(new Dimension(1000,1000));

        layoutComponents();
    }

    private void layoutComponents() {
        GridBagConstraints gc = new GridBagConstraints();

//        First Row (Table)
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 3;
        gc.weighty = 3;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;

        add(new JScrollPane(table), gc);

//        Next Row
        gc.gridwidth = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weighty = 0.01;

        add(new JButton("Edit"), gc);

        //        Next Row
        gc.fill = GridBagConstraints.VERTICAL;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weighty = 0.01;

        add(new JButton("Delete"), gc);
    }


//    Internal Util
    private void requestData() throws Exception {
        dataReadingService = new DataReadingServiceImpl();
        List<Person> people = dataReadingService.getAllPeople();

        for (Person p : people) {
            data = addEntry(data, p);
        }
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

//    Public Method to call when data is changed
    public void refreshData() throws Exception {
        this.removeAll();
        data = null;
        requestData();
        table = new CustomJTable(data, columns);
        this.repaint();
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.revalidate();
    }

}
