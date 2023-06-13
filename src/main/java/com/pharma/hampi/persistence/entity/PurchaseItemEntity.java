package com.pharma.hampi.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "purchases_products")
public class PurchaseItemEntity {

    @EmbeddedId
    private PurchasesProductPK id;

    private Integer quantity;

    private Double total;

    private Boolean status;

    @ManyToOne
    @MapsId("purchaseID")
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;


    //Getters and Setters


    public PurchasesProductPK getId() {
        return id;
    }

    public void setId(PurchasesProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PurchaseEntity getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
