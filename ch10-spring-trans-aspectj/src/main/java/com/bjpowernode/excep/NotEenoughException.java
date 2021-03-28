package com.bjpowernode.excep;

//自定义的运行时异常
public class NotEenoughException extends RuntimeException {
    public NotEenoughException() {
        super();
    }

    public NotEenoughException(String message) {
        super(message);
    }
}
