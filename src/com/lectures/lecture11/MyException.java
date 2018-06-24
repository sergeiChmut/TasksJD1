package com.lectures.lecture11;

public class MyException extends Exception{
    private Exception myException;

    public Exception getException() {
        return myException;
    }
}
