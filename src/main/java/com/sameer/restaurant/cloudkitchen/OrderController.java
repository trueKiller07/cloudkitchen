package com.sameer.restaurant.cloudkitchen;

import com.sameer.restaurant.cloudkitchen.dto.Order;
import com.sameer.restaurant.cloudkitchen.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        //messageProducer.sendMessage("orders-topic", message);
        return "Message sent: " + message;
    }

    @PostMapping("/sendOrder")
    public String sendMessage(@RequestBody Order order) {
        messageProducer.sendMessage("orders-topic", order.getPhoneNumber(), order);
        return "Message sent: " + order.toString();
    }
}
