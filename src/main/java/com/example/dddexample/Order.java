package com.example.dddexample;

import java.util.List;

/**
 * Order는 orderNumber를 식별자로 갖는 엔티티다.
 */
public class Order {
    private Orderer orderer;
    private List<OrderLine> orderLineList;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;
    private OrderNo id; // 식별자

    public OrderNo getId() {
        return id;
    }

    public Order(List<OrderLine> orderLineList) {
        setOrderLines(orderLineList);
        changeShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLineList) {
        verifyAtLeastOneOrMoreOrderLines(orderLineList);
        this.orderLineList = orderLineList;
        calculateTotalAmounts();
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

    public void changeShipped() {
        ...
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    public void completePayment() {
        ...
    }

    public void setShippingInfo(ShippingInfo newShippingInfo) {
        if (newShippingInfo == null) {
            throw new IllegalArgumentException();
        }
        this.shippingInfo = newShippingInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.id == null) return false;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        return result;
    }

}
