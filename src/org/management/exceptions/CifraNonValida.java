package org.management.exceptions;

public class CifraNonValida extends IllegalArgumentException{
    public CifraNonValida (String messaggio){
        super(messaggio);
    }
}
