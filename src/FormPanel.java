
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;


public class FormPanel extends JPanel {

    JTextField nameField;
    JComboBox<Object> employmentStatus;
    JCheckBox localCitizen;
    JTextField nationalNumber;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup genderGroup;

    public FormPanel() {
        nameField = new JTextField();

        employmentStatus = new JComboBox<>();
        employmentStatus.addItem("Employed");
        employmentStatus.addItem("Self-Employed");
        employmentStatus.addItem("Unemployed");

        nationalNumber = new JTextField();
        localCitizen = new JCheckBox();

        // CheckBox enables or disables the nationalNumber textField
        localCitizen.addActionListener(e -> {
            boolean checked = localCitizen.isEnabled();
            if (checked) {
                nationalNumber.setEnabled(checked);
                nationalNumber.setText("");
            } else {
                nationalNumber.setEnabled(checked);
            }
        });

        male = new JRadioButton();
        female = new JRadioButton();
        genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);

        setVisible(true);
        CompoundBorder border = new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10,10,10,10));
        setBorder(border);
        setLayout(new GridBagLayout());


        layoutComponents();
    }

    private void layoutComponents() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.001;

        // First row
        add(new JLabel("Name"), gc);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        add(nameField, gc);

    }

}
