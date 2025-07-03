package ir.najaftech.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ir.najaftech.model.EmploymentStatus;
import ir.najaftech.model.Gender;
import ir.najaftech.model.Person;

public class TextPanel extends JPanel {

    JTextArea textArea;
    JList listEmployees;
    ArrayList<Person> people;
    DefaultListModel model;
    
    public TextPanel() {
        people = new ArrayList<>();
        people.add(new Person(1, "Ali", EmploymentStatus.EMPLOYED, Gender.MALE, "0150082533"));
        model = new DefaultListModel<>();
        for(Person p : people) {
            model.addElement(p);
        }
        listEmployees = new JList(model);
        setLayout(new BorderLayout());
        setVisible(true);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setPreferredSize(new Dimension(1000,1000));
        add(listEmployees, BorderLayout.CENTER);
    }

    public void appendPerson(Person p) {
        this.people.add(p);
        this.model.addElement(p);
        for (Person m : people) {
            System.out.println(m);
        }
        repaint();
    }
}
