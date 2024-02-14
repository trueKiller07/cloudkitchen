package com.sameer.restaurant.cloudkitchen.kafka.producer;

import com.sameer.restaurant.cloudkitchen.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(String topic, String key, Order order) {
        kafkaTemplate.send(topic, key, order);
    }

}