package com.linketinder.microservices.db

class ConfigDataBase {
    private String dbType = "PostgreSQL"
    private String urlDB = "jdbc:postgresql://localhost:5432/linketinder"
    private String userDB = "postgres"
    private String senhaDB = "postgres"



    String getDbType() {
        return dbType
    }

    String getUrlDB() {
        return urlDB
    }

    String getUserDB() {
        return userDB
    }

    String getSenhaDB() {
        return senhaDB
    }
}
