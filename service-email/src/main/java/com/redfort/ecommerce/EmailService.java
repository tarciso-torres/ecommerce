package com.redfort.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.util.Map;

public class EmailService {

    public static void main(String args[]) throws IOException {

        var emailService = new EmailService();
        try(var service = new KafkaService(EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL",
                emailService::parse,
                String.class,
                Map.of())) {
            service.rum();
        }
    }

        private void parse(ConsumerRecord<String,String> record) {
            System.out.println("-------------------------------------------");
            System.out.println("Send email");
            System.out.println("key: " + record.key());
            System.out.println("value: " + record.value());
            System.out.println("partition: " + record.partition());
            System.out.println("offset: " + record.offset());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Email sent");
        }
}
