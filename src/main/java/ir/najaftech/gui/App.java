package ir.najaftech.gui;


import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;


public class App {
    public static void main(String[] args) throws Exception {
        
        EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            FlatDarculaLaf.setup();
            new MainFrame();
        });

        String url = "jdbc:sqlite:data.db";
        Connection connection;
        try {
        connection = DriverManager.getConnection(url);
        
        // String sql = "CREATE TABLE IF NOT EXISTS person(id BIGINT PRIMARY KEY, full_name VARCHAR(255))";
        // Statement statement = connection.createStatement();
        // statement.executeUpdate(sql);
        // System.out.println("Table Created");
        // sql = "INSERT INTO person VALUES(1, 'Ali Najafian')";
        // statement.executeUpdate(sql);
        // sql = "INSERT INTO person VALUES(2, 'Mahsas Mirzaei')";
        // statement.executeUpdate(sql);
        // System.out.println("Two Rows added to database");
        // ResultSet result = statement.executeQuery("SELECT * FROM person");
        // while (result.next()) {
        //     System.out.println(result.getInt("id"));
        //     System.out.println(result.getString("full_name"));
        // }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
