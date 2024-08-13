package org.controller.demo.SpringBoot_Controller;

public class Creditcard {
    private long cardNumber;
    private int cardAvailable;
    private int cardPin;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardAvailable() {
        return cardAvailable;
    }

    public void setCardAvailable(int cardAvailable) {
        this.cardAvailable = cardAvailable;
    }

    public int getCardPin() {
        return cardPin;
    }

    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }
}
