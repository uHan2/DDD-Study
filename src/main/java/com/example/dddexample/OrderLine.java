package com.example.dddexample;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class OrderLine {

    @EmbeddedId
    private ProductId productId;
    @Column(name = "price")
    private Money price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amounts")
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public int getAmounts(){
        ...
    }

    public int getPrice(){
        ...
    }

    public int getQuantity() {

    }

}
