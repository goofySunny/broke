package ir.najaftech.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

import ir.najaftech.model.EmploymentStatus;
import ir.najaftech.model.Gender;


public class FormPanel extends JPanel {

    JTextField nameField;
    JComboBox<Object> employmentStatus;
    JCheckBox localCitizen;
    JTextField nationalNumber;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup genderGroup;
    JButton okButton;

    private EventObjectEmitter eventObjectEmitter;

    public FormPanel() {
        nameField = new JTextField();

        employmentStatus = new JComboBox<>();
        employmentStatus.addItem("Employed");
        employmentStatus.addItem("Self-Employed");
        employmentStatus.addItem("Unemployed");

        nationalNumber = new JTextField();
        nationalNumber.setEnabled(false);
        nationalNumber.addKeyListener(new NumericTextFieldEnforcer());
        localCitizen = new JCheckBox();

        // CheckBox enables or disables the nationalNumber textField
        localCitizen.addActionListener(e -> {
            boolean checked = localCitizen.isSelected();
            if (checked) {
                nationalNumber.setEnabled(true);
            } else {
                nationalNumber.setEnabled(checked);
                nationalNumber.setText("");
            }
        });

        male = new JRadioButton(Gender.MALE.toString().toLowerCase());
        male.setSelected(true);
        female = new JRadioButton(Gender.FEMALE.toString().toLowerCase());
        genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);

        okButton = new JButton("OK");

        setVisible(true);
        CompoundBorder border = new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10,10,10,10));
        setBorder(border);
        setLayout(new GridBagLayout());

        okButton.addActionListener(e -> {
            String name = (String) nameField.getText();
            String selectedEmpStatus = (String) employmentStatus.getSelectedItem();
            EmploymentStatus empStatus = null;
            switch (selectedEmpStatus) {
                case "Employed":
                    empStatus = EmploymentStatus.EMPLOYED;
                    break;
                case "Self-Employed":
                    empStatus = EmploymentStatus.SELF_EMPLOYED;
                    break;
                default:
                    empStatus = EmploymentStatus.UNEMPLOYED;
                    break;
            }
            Gender selectedGender = male.isSelected() ? Gender.MALE : Gender.FEMALE;
            FormEvent eventDetails = new FormEvent(e, name, empStatus, selectedGender);
            if (localCitizen.isSelected()) {
                eventDetails.setNationalNumber((String) nationalNumber.getText());
            } else {
                eventDetails.setNationalNumber(null);
            }
            if (eventObjectEmitter != null) {
                try {
                    eventObjectEmitter.emitObject(eventDetails);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        layoutComponents();
    }

    private void layoutComponents() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.01;

        // First row
        gc.anchor = GridBagConstraints.BASELINE_LEADING;
    add(new JLabel("Name: "), gc);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        add(nameField, gc);


        // Next row
        gc.gridy++;
        // Label
        gc.gridx = 0;
        add(new JLabel("Employment Status: "), gc);
        // Control
        gc.gridx = 1;
        add(employmentStatus, gc);

        // Next row
        gc.gridy++;
        // Label
        gc.gridx = 0;
        add(new JLabel("Are you a local? "), gc);
        // Control
        gc.gridx = 1;
        add(localCitizen, gc);

        // Next row
        gc.gridy++;
        // Label
        gc.gridx = 0;
        add(new JLabel("National Number: "), gc);
        // Control
        gc.gridx = 1;
        add(nationalNumber, gc);
        
        // Next row
        gc.gridy++;
        // Label
        gc.gridx = 0;
        add(new JLabel("Sex: "), gc);
        // Control
        gc.gridx = 1;
        add(male, gc);

        // Next row
        gc.gridy++;
        // Control
        gc.gridx = 1;
        add(female, gc);

        // Next row
        gc.gridy++;
        // Ok Button
        gc.weighty = 1;
        gc.gridx = 1;
        add(okButton, gc);
    }

    public EventObjectEmitter getEventObjectEmitter() {
        return eventObjectEmitter;
    }

    public void setEventObjectEmitter(EventObjectEmitter eventObjectEmitter) {
        this.eventObjectEmitter = eventObjectEmitter;
    }

}