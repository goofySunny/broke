package ir.najaftech.gui;

import java.sql.SQLException;

public interface EventObjectEmitter {

    void emitObject(FormEvent source) throws Exception;

}
