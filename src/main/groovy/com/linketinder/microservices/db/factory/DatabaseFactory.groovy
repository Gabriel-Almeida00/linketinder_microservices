package com.linketinder.microservices.db.factory

import com.linketinder.microservices.db.ConfigDataBase

class DatabaseFactory {
    IDatabaseConnectionFactory createConnectionFactory(ConfigDataBase configDatabase) {
        String dbType = configDatabase.getDbType()

        if (dbType == "PostgreSQL") {
            return new DatabaseSQLConnectionFactory(configDatabase)
        }

        throw new IllegalArgumentException("Tipo de banco de dados não suportado: " + dbType)
    }
}
