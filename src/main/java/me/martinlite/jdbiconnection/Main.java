package me.martinlite.jdbiconnection;

import me.martinlite.jdbiconnection.sql.ConnectionSQL;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class Main {
    static ConnectionSQL connection = new ConnectionSQL();
    Jdbi conn = connection.getConnection();////This is the connection

    public static void main(String[] args) {
        // Suppose we want to create a program to get a person's money from their bank account
        Main main = new Main();
        main.insertUser("Britany",10);
        main.updateUser("Britany",20);
        if(main.userExist("Britany")){
            main.deleteUser("Britany");
        }
    }


    //The first step is to create the methods to obtain the player money

    public void insertUser(String username, int money) {
        if(!userExist(username)){
            try (Handle handle = conn.open()) { //handle is the option that allows you to access the jdbi options
                handle.createUpdate("INSERT INTO <TABLE> (name,money) VALUES (?,?)")
                        .define("TABLE", connection.getTable())
                        .bind(0, username)
                        .bind(1, money)
                        .execute();
                System.out.println("User "+username+" has been correctly entered with the amount of money of "+money+"$");
            }
        }else {
            System.out.println("ERROR There is already a user with that nick \nPlease enter another name");
        }

    }

    public void deleteUser(String username) {
        if(userExist(username)){
            try (Handle handle = conn.open()) {
                handle.createUpdate("DELETE FROM `<TABLE>`  WHERE `name`=? ")
                        .define("TABLE", connection.getTable())
                        .bind(0, username)
                        .execute();
                System.out.println("User "+username+" has been successfully removed");
            }
        }else {
            System.out.println("ERROR unknown user");
        }

    }

    public void updateUser(String username, int money) {
        if(userExist(username)){
            try (Handle handle = conn.open()) {
                handle.createUpdate("UPDATE <TABLE> SET money=? WHERE name = ?")
                        .define("TABLE", connection.getTable())
                        .bind(0, money)
                        .bind(1, username)
                        .execute();
                System.out.println(username+" money has been updated to = "+money);
            }
        }else {
            System.out.println("ERROR unknown user");
        }

    }

    public int getMoney(String username) {
        if(userExist(username)){
            try (Handle handle = conn.open()) {
                return handle.select("SELECT money FROM <TABLE> WHERE name= ? ")
                        .define("TABLE", connection.getTable())
                        .bind(0, username)
                        .mapTo(Integer.class)
                        .findOnly();
            }
        }else{
            System.out.println("ERROR unknown user");
        }
     return -1;
    }

    public boolean userExist(String username) {
        try (Handle handle = conn.open()) {
            return handle.select("SELECT `name` FROM <TABLE> WHERE `name`= ? ")
                    .define("TABLE", connection.getTable())
                    .bind(0, username)
                    .mapTo(String.class)
                    .findFirst().isPresent();
        }


    }
}
