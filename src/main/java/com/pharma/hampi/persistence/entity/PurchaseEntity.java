package com.pharma.hampi.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")

public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer purchaseID;

    @Column(name = "customer_id")
    private String customerID;

    private LocalDateTime date;

    @Column(name = "payment_method")
    private Character paymentMethod;

    private String comment;
    private Character status;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<PurchaseItemEntity> products;

    //Getters and Setters


    public Integer getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Integer purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Character getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Character paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<PurchaseItemEntity> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseItemEntity> products) {
        this.products = products;
    }
}
