package com.tutorial.ecommerce_be.exception;

public class UserNotVerifiedExeption extends Exception {
    public boolean isNewEmailSent;
    private boolean newEmailSent;

    public UserNotVerifiedExeption(Boolean newEmailSent) {
        this.newEmailSent = newEmailSent;
    }

    public Boolean isNewEmailSent() {
        return newEmailSent;
    }
}
