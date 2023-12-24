package com.example.springboottutorial.error;

public class DepartmentNotFountException  extends  Exception{

    public DepartmentNotFountException() {
        super();
    }

    public DepartmentNotFountException(String message) {
        super(message);
    }

    public DepartmentNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFountException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
