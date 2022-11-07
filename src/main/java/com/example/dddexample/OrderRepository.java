package com.example.dddexample;

public interface OrderRepository {
    Order findByNumber(OrderNumber number);

    void save(Order order);

    void delete(Order order);
}
