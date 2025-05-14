package ir.najaftech.gui;


import java.awt.EventQueue;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class App {
    public static void main(String[] args) throws Exception {
        
        EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            FlatDarculaLaf.setup();
            new MainFrame();
        });
    }
}
