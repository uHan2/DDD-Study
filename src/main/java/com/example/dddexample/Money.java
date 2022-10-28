package com.example.dddexample;

import lombok.Getter;

@Getter
public record Money(int value) {

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}
