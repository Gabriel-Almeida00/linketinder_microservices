package com.linketinder.microservices.db.factory

import com.linketinder.microservices.db.ConfigDataBase
import com.linketinder.microservices.db.IDatabaseConnection
import com.linketinder.microservices.exception.DataBaseException

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class DatabaseSQLConnectionSingleton implements IDatabaseConnection{
    private final ConfigDataBase config
    private Connection connection
    private static DatabaseSQLConnectionSingleton instance

    private DatabaseSQLConnectionSingleton(ConfigDataBase config) {
        this.config = config
    }

    static DatabaseSQLConnectionSingleton getInstance(ConfigDataBase config) {
        if (instance == null) {
            instance = new DatabaseSQLConnectionSingleton(config)
        }
        return instance
    }

    @Override
    Connection getConnection() {
        try {
            String dbUrl = config.getUrlDB()
            String dbUser = config.getUserDB()
            String dbPassword = config.getSenhaDB()

            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
        } catch (SQLException e) {
            throw new DataBaseException("Erro ao obter a conexão com o banco de dados." + e)
        }
    }

    @Override
    PreparedStatement prepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql)
    }

    @Override
    ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        return statement.executeQuery()
    }
}
