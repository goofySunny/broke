package ir.najaftech;

import java.io.File;
import javax.swing.filechooser.FileFilter;;

public class FileChooserFilter extends FileFilter {

    private final String acceptedExtension = "njf";

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        if (extractfileExtension(f.toString()).endsWith("njf")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Najafical Files (*.njf)";
    }

    private String extractfileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex == -1) {
            return null;
        }
        if (dotIndex == fileName.length() - 1) {
            return null;
        }

        String extension = fileName.substring(dotIndex, fileName.length() - 1);
        return extension;
    }
    
}