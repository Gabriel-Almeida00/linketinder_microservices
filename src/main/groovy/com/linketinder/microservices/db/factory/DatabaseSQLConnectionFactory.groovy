package com.linketinder.microservices.db.factory

import com.linketinder.microservices.db.ConfigDataBase
import com.linketinder.microservices.db.IDatabaseConnection

class DatabaseSQLConnectionFactory implements IDatabaseConnectionFactory{
    private final ConfigDataBase config

    DatabaseSQLConnectionFactory(ConfigDataBase config) {
        this.config = config
    }

    @Override
    IDatabaseConnection createConnection() {
        return  DatabaseSQLConnectionSingleton.getInstance(config)
    }
}