package com.linketinder.microservices.db.factory

import com.linketinder.microservices.db.IDatabaseConnection

interface IDatabaseConnectionFactory {
    IDatabaseConnection createConnection();
}