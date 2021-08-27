package me.martinlite.jdbiconnection.sql;

import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Jdbi;


public class SQLClient {
    public Jdbi getConnection() {
        return connection;
    }

    final Jdbi connection;

    public static Builder newSQLClient() {

        return new Builder();

    }

    public SQLClient(HikariDataSource dataSource) {

        this.connection =  Jdbi.create(dataSource);
    }





}