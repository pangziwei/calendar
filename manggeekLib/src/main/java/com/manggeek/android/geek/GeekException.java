package com.manggeek.android.geek;

public class GeekException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GeekException() {
        super();
    }

    public GeekException(String msg) {
        super(msg);
    }

    public GeekException(Throwable ex) {
        super(ex);
    }

    public GeekException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
