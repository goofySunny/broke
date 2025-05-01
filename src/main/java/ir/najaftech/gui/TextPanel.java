package ir.najaftech.gui;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

    JTextArea textArea;
    
    public TextPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        setVisible(true);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(textArea, BorderLayout.CENTER);
    }

    public void appendText(String text) {
        this.textArea.append(text);
    }
}
