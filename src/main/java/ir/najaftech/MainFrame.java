package ir.najaftech;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


public class MainFrame extends JFrame {

    JMenuBar menu;
    TextPanel textPanel;
    FormPanel formPanel;

    public MainFrame() {
        super("By Niggas, For Niggas");

        // try {
        //     UIManager.setLookAndFeel(new FlatDarculaLaf());
        // } catch(Exception e) {
        //     System.out.println("Failed to initialize Flat");
        // }

        menu = new JMenuBar();
        initMenu();

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

        setJMenuBar(menu);
        add(textPanel, BorderLayout.EAST);
        add(formPanel, BorderLayout.WEST);
    }

    private void initMenu() {

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem importMenuItem = new JMenuItem("Import Data...");
        JMenuItem exportMenuItem = new JMenuItem("Export Data...");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);

        fileMenu.add(importMenuItem);
        fileMenu.add(exportMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        JMenu windowMenu = new JMenu("Window");
        JCheckBoxMenuItem flatLafCheckbox = new JCheckBoxMenuItem("Light Theme");
        flatLafCheckbox.addActionListener(e -> {
            if (flatLafCheckbox.isSelected()) {
                FlatLightLaf.setup();
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (Exception e1) {
                    System.out.println("Failed");
                }
            } else {
                FlatDarculaLaf.setup();
                try {
                    UIManager.setLookAndFeel(new FlatDarculaLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (Exception e2) {
                    System.out.println("Failed");
                }
            }
        });
        windowMenu.add(flatLafCheckbox);


        menu.add(fileMenu);
        menu.add(windowMenu);
    }

}
