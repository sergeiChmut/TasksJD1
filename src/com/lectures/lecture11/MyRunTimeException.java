package com.lectures.lecture11;

public class MyRunTimeException extends RuntimeException {
    private Exception myException;
    public MyRunTimeException (String error, Exception e){
        super(error);
        myException=e;
    }
    public MyRunTimeException (String error) {
        super(error);
    }
    public Exception getException() {
        return myException;
    }
}
