package me.martinlite.jdbiconnection;

import me.martinlite.jdbiconnection.sql.ConnectionSQL;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class Main {
    static ConnectionSQL connection = new ConnectionSQL();

    public static void main(String[] args) {
        Jdbi conn = connection.getConnection(); //This is the connection


    }


}
