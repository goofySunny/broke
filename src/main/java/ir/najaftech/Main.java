package ir.najaftech;


import java.awt.EventQueue;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import ir.najaftech.gui.Expenses.ExpenseParentPanel;
import ir.najaftech.gui.MainFrame;


public class Main {
    public static void main(String[] args) throws Exception {
        
        EventQueue.invokeLater(() -> {
            FlatDarculaLaf.setup();
            try {
                new MainFrame(new ExpenseParentPanel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}
