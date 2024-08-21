package org.controller.demo.SpringBoot_Controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cardcredit")
public class Creditcard {
    @Id// primary key
    @Column(name = "customer_id")
    private long cardNumber;
    @Column(name = "available_limit")
    private int cardAvailable;
    @Column(name = "secret_key")
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
