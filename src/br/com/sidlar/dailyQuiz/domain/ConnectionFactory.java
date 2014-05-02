package br.com.sidlar.dailyQuiz.domain;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ADMILSON on 23/04/14.
 */
public class ConnectionFactory {
    public Connection getConnectionMySql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/dailyquiz", "root", "ROOT");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
