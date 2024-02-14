package com.sameer.restaurant.cloudkitchen.kafka.consumer;

import com.sameer.restaurant.cloudkitchen.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "orders-topic", groupId = "my-group-id")
    public void listen(@Payload List<Order> messages, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                       @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.toString() + " - " + partitions.get(i) + "-" + offsets.get(i) + "");
        }
    }
}
