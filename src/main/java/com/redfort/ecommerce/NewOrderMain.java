package com.redfort.ecommerce;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException {
        try(var dispatcher = new KafkaDispatcher()){
            for(var i = 0; i < 10; i++) {

                var key = UUID.randomUUID().toString();
                var value = key + ",67523,98709870931";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

                var email = "Thank for you order! We are processing your order!";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, value);
            }
        }
    }
}
