package ir.najaftech.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
import ir.najaftech.model.Expense;

public class MainFrame extends JFrame {

    JMenuBar menu;

    private JFileChooser fileChooser;
    private ExpenseAdditionForm expenseForm;
    private GraphPanel graphPanel;

    public MainFrame() {
        super("By Niggas, For Niggas");

        graphPanel = new GraphPanel(new ArrayList<Expense>());
        expenseForm = new ExpenseAdditionForm();
        expenseForm.setFormObjectEmitter((e, expense) -> {
            System.out.println("We in Main frame");
            graphPanel.addExpense(expense);
        });
        menu = new JMenuBar();
        initMenu();

        setVisible(true);
        setSize(700, 500);
        setLayout(new BorderLayout());

        add(expenseForm, BorderLayout.WEST);
        add(graphPanel, BorderLayout.EAST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menu);
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
            int exit = JOptionPane.showConfirmDialog(MainFrame.this, "Quit application?", "Confirm Exit",
                    JOptionPane.OK_CANCEL_OPTION);
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
