package org.management.exceptions;

public class DataEventoInvalidaException extends IllegalArgumentException {
    public DataEventoInvalidaException(String messaggio){
        super(messaggio);
    }
}
