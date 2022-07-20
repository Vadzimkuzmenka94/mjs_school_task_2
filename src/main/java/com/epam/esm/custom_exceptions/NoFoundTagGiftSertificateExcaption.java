package com.epam.esm.custom_exceptions;

public class NoFoundTagGiftSertificateExcaption extends RuntimeException {
    public NoFoundTagGiftSertificateExcaption(String message) {
        super(message);
    }
}