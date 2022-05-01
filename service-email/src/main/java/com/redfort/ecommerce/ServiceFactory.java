package com.redfort.ecommerce;

public interface ServiceFactory<T> {
    ConsumerService<T> create();
}
