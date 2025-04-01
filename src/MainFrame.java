
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class MainFrame extends JFrame {

    TextPanel textPanel;

    public MainFrame() {
        super("By Niggas, For Niggas");

        textPanel = new TextPanel();
        textPanel.setPreferredSize(new Dimension(350, 500));

        setVisible(true);
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.GTKLookAndFeel");
        } catch (Exception e) {   
        }        

        add(textPanel, BorderLayout.EAST);

    }

}
