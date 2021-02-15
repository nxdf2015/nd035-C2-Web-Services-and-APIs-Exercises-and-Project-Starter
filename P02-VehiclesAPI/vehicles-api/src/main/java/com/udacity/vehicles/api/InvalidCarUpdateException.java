package com.udacity.vehicles.api;

public class InvalidCarUpdateException extends Throwable {
    public InvalidCarUpdateException(String s) {
        super(s);
    }
}
