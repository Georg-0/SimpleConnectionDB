package com.lohov;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;//создаем соединение

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();//драйвер и драйвер-менеджер
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);//получаем соединение
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено!");
            }
            connection.close();
            if(connection.isClosed()){
                System.out.println("Соединение с БД закрыто!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
