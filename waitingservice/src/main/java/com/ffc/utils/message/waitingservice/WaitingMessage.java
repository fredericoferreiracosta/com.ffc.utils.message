package com.ffc.utils.message.waitingservice;

/**
 * A waiting message representation.
 */
public class WaitingMessage {

    private String language;
    private String message;

    public WaitingMessage(String language, String message) {
        this.language = language;
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
