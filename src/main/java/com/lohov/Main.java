package com.lohov;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();//драйвер и драйвер-менеджер
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();//создаем коннект и стэйт
            statement.execute("insert into animal(anim_name, anim_desc) values('loh','cat')");        //выполняем стат. запросы
            statement.executeUpdate("update animal set anim_name = 'Pluha' where anim_desc = 'Dog';");//с помощью statemen.execute и т.д.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
