package com.college.exception;

public class RecordAlreadyExistException extends RuntimeException {

    // runtimeexception is a serializable class so we need to add
    //Serial versionUID for this class
    private static final long serialVersionUID = 8493450276700306267L;

    public RecordAlreadyExistException() {
    }

    public RecordAlreadyExistException(String message) {
        super(message);

    }

}
