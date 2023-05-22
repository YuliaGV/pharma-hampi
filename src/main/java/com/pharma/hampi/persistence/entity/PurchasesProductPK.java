package com.pharma.hampi.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PurchasesProductPK implements Serializable {

    @Column(name = "purchase_id")
    private Integer purchaseID;


    @Column(name = "product_id")
    private Integer productID;


    //Getters and Setters


    public Integer getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Integer purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
