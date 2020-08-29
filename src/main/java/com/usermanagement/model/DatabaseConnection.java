package com.usermanagement.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public Connection getConnection(){
        try {
            FileReader fileReader= new FileReader("D:\\Servelet\\UserManagementSystem\\src\\main\\webapp\\WEB-INF\\database.properties");
            Properties properties=new Properties();
            properties.load(fileReader);
            Class.forName(properties.getProperty("driverClassName"));
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"),
                    properties.getProperty("password"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
