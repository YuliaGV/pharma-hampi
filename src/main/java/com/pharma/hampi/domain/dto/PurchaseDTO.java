package com.pharma.hampi.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseDTO {

    private int purchaseId;
    private String customerId;
    private LocalDateTime date;
    private char paymentMethod;
    private String comment;
    private char status;
    private List<PurschaseItemDTO> items;


    //Getters and Setters


    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public char getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(char paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public List<PurschaseItemDTO> getItems() {
        return items;
    }

    public void setItems(List<PurschaseItemDTO> items) {
        this.items = items;
    }
}
