package com.quipv.app.DBO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class MySQLConnection {
    private static final MySQLConnection mySQLConnection = new MySQLConnection();
    private Connection connection;
    private String host, user, password;

    private MySQLConnection(){
        getConnectionString();
        try {
            this.connection = DriverManager.getConnection(
                     host, user, password);
        }catch (Exception e){ System.out.println(e);}
    }

    public static MySQLConnection getInstance(){
        return mySQLConnection;
    }

    public Connection getConnection(){
        return this.connection;
    }

    private void getConnectionString() {
        Properties prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("application.properties").getFile());

        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);

            // get the properties value
            host = prop.getProperty("spring.datasource.url", "jdbc:mysql://localhost/quipv?useSSL=false");
            user = prop.getProperty("spring.datasource.username", "root");
            password = prop.getProperty("spring.datasource.password", "");
        } catch (IOException e) {System.out.println(e);}
    }
}
