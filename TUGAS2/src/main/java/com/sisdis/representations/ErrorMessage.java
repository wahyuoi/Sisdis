package com.sisdis.representations;

/**
 * Created by wahyuoi on 9/30/15.
 */
public class ErrorMessage {
    final int code;
    final String message;

    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
