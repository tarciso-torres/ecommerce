package com.redfort.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Properties;

public class FraudDetectorService {

    public static void main(String args[]) {

        var fraudService = new FraudDetectorService();
        var service = new KafkaService(FraudDetectorService.class.getSimpleName(),"ECOMMERCE_NEW_ORDER", fraudService::parse);
        service.rum();
    }
        private void parse(ConsumerRecord<String,String> record) {
            System.out.println("-------------------------------------------");
            System.out.println("Processing new order, checking for fraud");
            System.out.println("Key: " + record.key());
            System.out.println("Value: " + record.value());
            System.out.println("Partição: " + record.partition());
            System.out.println("Offset: " + record.offset());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Order processed");
        }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorService.class.getSimpleName());
        return properties;
    }
}
