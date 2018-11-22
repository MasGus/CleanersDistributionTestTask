package com.servicepartnerone.code.challenge.exception;

/**
 * @author Maria.Guseva
 */
public class WrongInputException extends RuntimeException {
    public WrongInputException() {
        super();
    }

    public WrongInputException(String message) {
        super(message);
    }
}
