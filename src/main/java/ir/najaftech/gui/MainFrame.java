package ir.najaftech.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import ir.najaftech.model.Person;
import ir.najaftech.services.DataWritingService;
import ir.najaftech.services.DataWritingServiceImpl;


public class MainFrame extends JFrame {

    private DataWritingService dataWritingService;

    JMenuBar menu;
    TextPanel textPanel;
    FormPanel formPanel;

    private JFileChooser fileChooser;

    public MainFrame() throws Exception {
        super("By Niggas, For Niggas");
        dataWritingService = new DataWritingServiceImpl();


        menu = new JMenuBar();
        initMenu();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileChooserFilter());
        
        textPanel = new TextPanel();
        textPanel.setPreferredSize(new Dimension(350, 500));

        formPanel = new FormPanel();
        formPanel.setEventObjectEmitter(e -> {
            if (e.getNationalNumber() == null) {
                e.setNationalNumber("");
            }
            Person p = new Person(e.getName(), e.getEmploymentStatus(), e.getGender(), e.getNationalNumber());
            dataWritingService.writePerson(p);
            textPanel.refreshData();
        });
        formPanel.setPreferredSize(new Dimension(350, 500));

        setVisible(true);
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menu);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);
    }

    private void initMenu() {

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
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

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
