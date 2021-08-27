package me.martinlite.jdbiconnection;

import me.martinlite.jdbiconnection.sql.ConnectionSQL;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;

public class Main {
    static ConnectionSQL connection = new ConnectionSQL();
    Jdbi conn = connection.getConnection();////This is the connection

    public static void main(String[] args) {
        // Suppose we want to create a program to get a person's money from their bank account
        Main main = new Main();
        int money = main.getMoney("Martin");

    }


    //The first step is to create the methods to obtain the player money

    public void insertUser(String username, int money) {
        try (Handle handle = conn.open()) { //handle is the option that allows you to access the jdbi options
            handle.createUpdate("INSERT INTO <TABLE> (name,money) VALUES (?,?)")
                    .define("TABLE", connection.getTable())
                    .bind(0, username)
                    .bind(1, money)
                    .execute();
        }
    }

    public void deleteUser(String username) {
        try (Handle handle = conn.open()) {
            handle.createUpdate("DELETE FROM `<TABLE>`  WHERE `name`=? ")
                    .define("TABLE", connection.getTable())
                    .bind(0, username)
                    .execute();
        }
    }
    public void updateUser(String username,int money){
        try (Handle handle = conn.open()) {
            handle.createUpdate("UPDATE <TABLE> SET money=? WHERE name = ?")
            .define("TABLE",connection.getTable())
            .bind(0,money)
            .bind(1,username)
            .execute()
            ;
        }
    }
    public int getMoney(String username){
        try (Handle handle = conn.open()) {
    int money = handle.select("SELECT money FROM <TABLE> WHERE name= ? ")
            .define("TABLE",connection.getTable())
            .bind(0,username)
            .mapTo(Integer.class)
            .findOnly();
        return money;
        }
    }
}
