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
        if (!Character.isDigit(c)) {
            e.consume();
        }
    }
}
