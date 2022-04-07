package com.redfort.ecommerce;

import java.util.UUID;

public class CorrelationId {

    private final String id;

    public CorrelationId() {
        id = UUID.randomUUID().toString();
    }
}
