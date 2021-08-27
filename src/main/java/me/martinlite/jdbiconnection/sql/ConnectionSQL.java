package me.martinlite.jdbiconnection.sql;

import org.jdbi.v3.core.Jdbi;

public class ConnectionSQL {

    public Jdbi getConnection(){
        SQLClient client = SQLClient.newSQLClient().ip("localhost").port("3306").database("prueba").user("root").password("admin").build(); //agregamos los parametros de la base de datos
        Jdbi jdbi = client.getConnection(); //obtenemos la conexion
        return jdbi; //retornamos la conexcion
    }
}
