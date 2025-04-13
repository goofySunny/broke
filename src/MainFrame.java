
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class MainFrame extends JFrame {

    TextPanel textPanel;
    FormPanel formPanel;

    public MainFrame() {
        super("By Niggas, For Niggas");

        textPanel = new TextPanel();
        textPanel.setPreferredSize(new Dimension(350, 500));

        formPanel = new FormPanel();
        formPanel.setEventObjectEmitter(e -> {
            StringBuilder text = new StringBuilder();
            text.append("Name: ");
            text.append(e.getName());
            text.append("\n");
            if (e.getNationalNumber() == null) {
                text.append("They are not local");
            } else {
                text.append("National Number: ");
                text.append(e.getNationalNumber());
            }
            text.append("\n");
            text.append("They are: ");
            text.append(e.getGender().equals("Male") ? e.getGender() : "Bitch");
            text.append("\n");

            textPanel.appendText(text.toString());
        });
        formPanel.setPreferredSize(new Dimension(350, 500));

        setVisible(true);
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();   
        }

        add(textPanel, BorderLayout.EAST);
        add(formPanel, BorderLayout.WEST);

    }

}
