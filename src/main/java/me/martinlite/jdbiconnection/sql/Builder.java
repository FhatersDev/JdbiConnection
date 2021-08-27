package me.martinlite.jdbiconnection.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Builder {

    final HikariConfig config = new HikariConfig();

    private String jdbc = "jdbc:mysql://{1}:{2}/{3}?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public Builder ip(String ip) {
        this.jdbc = jdbc.replace("{1}", ip);
        return this;
    }



    public Builder port(String port) {

        this.jdbc = jdbc.replace("{2}", port);
        return this;
    }

    public Builder database(String name) {
        this.jdbc = jdbc.replace("{3}", name);
        return this;
    }

    public Builder user(String user) {
        config.setUsername(user);
        return this;
    }

    public Builder password(String password) {
        config.setPassword(password);
        return this;
    }

    public SQLClient build() {
      
        config.setJdbcUrl(jdbc);
        config.setMaximumPoolSize(6);

        return new SQLClient(new HikariDataSource(config));
    }

}
