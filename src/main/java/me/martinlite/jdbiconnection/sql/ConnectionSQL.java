package me.martinlite.jdbiconnection.sql;

import org.jdbi.v3.core.Jdbi;

public class ConnectionSQL {

    public Jdbi getConnection(){
        SQLClient client = SQLClient.newSQLClient().ip("localhost").port("3306").database("prueba").user("root").password("admin").build(); //we add the data from the database
        Jdbi jdbi = client.getConnection(); //we get the connection
        return jdbi; //we return the connection
    }
}
