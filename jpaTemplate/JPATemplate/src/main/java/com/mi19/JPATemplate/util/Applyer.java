package com.mi19.JPATemplate.util;

import java.util.function.Consumer;

public class Applyer<T> {
    private final T t;
    private final Boolean accepted;
    Applyer(T t, Boolean accepted){
        this.t=t;
        this.accepted=accepted;

    }
    public void thenApply(Consumer<T> consumer){
        if (accepted)consumer.accept(t);
    }
}
