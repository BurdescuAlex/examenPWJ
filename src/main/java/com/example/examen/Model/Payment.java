package com.example.examen.Model;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private paymentType type;

    @Column
    @NotNull
    private String customer;

    @Column
    @NotNull
    private double amount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private paymentStatus status;

    public Payment(){}

    public Payment(paymentType type, String customer, double amount, paymentStatus status){
        this.type = type;
        this.customer=customer;
        this.amount=amount;
        this.status=status;
    }

    public Payment(long id,paymentType type, String customer, double amount, paymentStatus status){
        this.id=id;
        this.type = type;
        this.customer=customer;
        this.amount=amount;
        this.status=status;
    }

    public enum paymentType {
        ONLINE,
        POS
    }

    public enum paymentStatus {
        NEW,
        PROCESSED,
        CANCELLED
    }

    public paymentType getType() {
        return type;
    }

    public void setType(paymentType type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public paymentStatus getStatus() {
        return status;
    }

    public void setStatus(paymentStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
