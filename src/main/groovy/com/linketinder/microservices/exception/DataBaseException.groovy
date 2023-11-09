package com.linketinder.microservices.exception

class DataBaseException extends RuntimeException {
    DataBaseException(String message) {
        super(message)
    }
}
