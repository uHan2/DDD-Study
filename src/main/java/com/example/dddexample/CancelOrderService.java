package com.example.dddexample;

import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {
    private OrderRepository orderRepository;

    @Transactional
    public void cancel(OrderNumber orderNumber) {
        Order order = orderRepository.findByNumber(orderNumber);
        if(order == null) throw new NoOrderException(orderNumber);
        order.cancel();
    }
}
