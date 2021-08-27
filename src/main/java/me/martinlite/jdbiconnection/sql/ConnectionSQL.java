package me.martinlite.jdbiconnection.sql;

import org.jdbi.v3.core.Jdbi;

public class ConnectionSQL {
    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    public String getTable(){
        return table;
    }

    String ip = "localhost";
    String port = "3306";
    String database = "bank";
    String user = "root";
    String pass = "admin";
    String table = "banco";
    public Jdbi getConnection(){
        SQLClient client = SQLClient.newSQLClient().ip(ip).port(port).database(database).user(user).password(pass).build(); //agregamos los parametros de la base de datos
        Jdbi jdbi = client.getConnection(); //obtenemos la conexion
        return jdbi; //retornamos la conexcion
    }
}
