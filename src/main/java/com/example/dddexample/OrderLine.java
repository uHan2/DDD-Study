package com.example.dddexample;

public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = caculateAmounts();
    }

    private int caculateAmounts() {
        return price * quantity;
    }

    public int getAmounts(){
        ...
    }

}
