package ir.najaftech;


import java.awt.EventQueue;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import ir.najaftech.gui.MainFrame;
import ir.najaftech.services.DataReadingService;
import ir.najaftech.services.DataReadingServiceImpl;



public class App {
    public static void main(String[] args) throws Exception {
        
        EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            FlatDarculaLaf.setup();
            try {
                new MainFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
