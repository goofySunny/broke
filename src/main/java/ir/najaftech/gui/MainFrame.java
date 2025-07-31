package ir.najaftech.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import ir.najaftech.gui.Contacts.ContactParentPanel;
import ir.najaftech.gui.Expenses.ExpenseParentPanel;

public class MainFrame extends JFrame {


    JMenuBar menu;
    
    JPanel displayingPanel;


    private JFileChooser fileChooser;

    public MainFrame(JPanel startingPoint) throws Exception {
        super("By Najaf, For Najaf");

        initSelf();

        if (startingPoint != null) {
            this.displayingPanel = startingPoint;
            this.add(displayingPanel);
        }

    }

    private void initSelf() {

        menu = new JMenuBar();
        initMenu();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileChooserFilter());

        setVisible(true);
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menu);
    }

    private void initMenu() {

//        File Menu Config
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem importMenuItem = new JMenuItem("Import Data...");
        importMenuItem.addActionListener(e -> {
            fileChooser.showOpenDialog(MainFrame.this);
        });
        JMenuItem exportMenuItem = new JMenuItem("Export Data...");
        exportMenuItem.addActionListener(e -> {
            fileChooser.showSaveDialog(MainFrame.this);
        });
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

        exitMenuItem.addActionListener(e -> {
            int exit = JOptionPane.showConfirmDialog(MainFrame.this, "Quit application?",  "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
            if (exit == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        });

        fileMenu.add(importMenuItem);
        fileMenu.add(exportMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

//        Window Menu Config
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

        JMenuItem contactMenu = new JMenuItem("Contact Management");
        contactMenu.addActionListener(e -> {
            if (this.displayingPanel != null) this.remove(displayingPanel);
            try {
            this.displayingPanel = new ContactParentPanel();
            this.add(displayingPanel);
            } catch (Exception ex) {
                System.out.println("Something went wrong");
            }
            SwingUtilities.updateComponentTreeUI(this);
            repaint();
        });
        windowMenu.add(contactMenu);

        JMenuItem expenseMenu = new JMenuItem("Expense Management");
        expenseMenu.addActionListener(e -> {
            if (this.displayingPanel != null) this.remove(displayingPanel);
            try {
                this.displayingPanel = new ExpenseParentPanel();
                this.add(displayingPanel);
            } catch (Exception ex) {
                System.out.println("Something went wrong");
            }
            SwingUtilities.updateComponentTreeUI(this);
            repaint();
        });
        windowMenu.add(expenseMenu);


        menu.add(fileMenu);
        menu.add(windowMenu);
    }

}
