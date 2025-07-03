package ir.najaftech.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumericTextFieldEnforcer implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c == KeyEvent.VK_BACK_SPACE) {
            System.out.println("BackSpace pressed");
        } else if (c == KeyEvent.VK_TAB) {
            System.out.println("tab");
        }else if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_RIGHT) {
            System.out.println("Arrow Key");
        } else if (!Character.isDigit(c)) {
            e.consume();
        }
    }
}
