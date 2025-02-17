package com.example.demo.utility;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager(){}           //Made private so you can't create an instance from constructor

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }
        try(InputStream propertiesFile = new FileInputStream("src/main/resources/application.properties")){ //Automaticly closes file when inside the try with resources
            Properties props = new Properties();
            props.load(propertiesFile);
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException | IOException e){
            e.printStackTrace();
        }
        return conn;
    }
}
