package ir.najaftech.gui.Contacts;

import ir.najaftech.model.Person;
import ir.najaftech.services.ContactRepositoryService;
import ir.najaftech.services.ContactRepositoryServiceImpl;

import javax.swing.*;
import java.awt.*;

public class ContactParentPanel extends JPanel {

    private ContactRepositoryService contactRepositoryService;

    ContactListPanel contactListPanel;
    ContactAdditionForm contactAdditionForm;


    public ContactParentPanel() throws Exception {
        contactRepositoryService = new ContactRepositoryServiceImpl();

        contactListPanel = new ContactListPanel();
        contactListPanel.setPreferredSize(new Dimension(350, 500));

        contactAdditionForm = new ContactAdditionForm();
        contactAdditionForm.setEventObjectEmitter(e -> {
            if (e.getNationalNumber() == null) {
                e.setNationalNumber("");
            }
            Person p = new Person(e.getName(), e.getEmploymentStatus(), e.getGender(), e.getNationalNumber());
            contactRepositoryService.writePerson(p);
            contactListPanel.refreshData();
        });
        contactAdditionForm.setPreferredSize(new Dimension(350, 500));

        this.setLayout(new BorderLayout());

        this.add(contactAdditionForm, BorderLayout.WEST);
        this.add(contactListPanel, BorderLayout.CENTER);

    }

}
