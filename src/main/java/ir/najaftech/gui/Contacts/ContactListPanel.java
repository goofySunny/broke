package ir.najaftech.gui.Contacts;

import ir.najaftech.util.CustomJTable;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import ir.najaftech.model.Person;
import ir.najaftech.services.ContactRepositoryService;
import ir.najaftech.services.ContactRepositoryServiceImpl;

public class ContactListPanel extends JPanel {

    ContactRepositoryService contactRepositoryService;

    private final Object[][] placeHolderData = {{"Example", "???", "???", "???"}};
    private final String[] columns = {"Name", "Employment", "Gender", "local"};


    Object[][] data;
    CustomJTable table;
    JButton editButton;
    JButton deleteButton;
    
    public ContactListPanel() throws Exception {
        requestData();
        initSelf();

        setLayout(new GridBagLayout());
        setVisible(true);
        setPreferredSize(new Dimension(1000,1000));

        layoutComponents();
    }
    
    public void initSelf() {
        if (data == null) {
            data = placeHolderData;
        }
        
        table = new CustomJTable(data, columns);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        editButton = new JButton("Edit");
        editButton.addActionListener(e -> {
            if (table.getSelectedRow() != -1) {
                Object[] selectedRow = data[table.getSelectedRow()];
                new ContactEditPopUpFrame(selectedRow, this);
            }
        });
        deleteButton = new JButton("Delete");
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

        add(editButton, gc);

        //        Next Row
        gc.fill = GridBagConstraints.VERTICAL;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weighty = 0.01;

        add(deleteButton, gc);
    }


//    Internal Util
    private void requestData() throws Exception {
        contactRepositoryService = new ContactRepositoryServiceImpl();
        List<Person> people = contactRepositoryService.getAllPeople();

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
        layoutComponents();
        this.revalidate();
    }

}
