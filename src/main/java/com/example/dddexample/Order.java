package com.example.dddexample;

import java.util.List;

public class Order {
    private List<OrderLine> orderLineList;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLineList) {
        setOrderLines(orderLineList);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLineList) {
        verifyAtLeastOneOrMoreOrderLines(orderLineList);
        this.orderLineList = orderLineList;
        calculateTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLineList) {
        if (orderLineList == null || orderLineList.isEmpty()) {
            throw new IllegalArgumentException("No OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLineList.stream().mapToInt(OrderLine::getAmounts).sum();
        this.totalAmounts = new Money(sum);
    }

    public void changeShipped(){
        ...
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo){
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING){
            throw new IllegalStateException("already shipped");
        }
    }

    public void completePayment() {
        ...
    }

}
