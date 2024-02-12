package com.sameer.restaurant.cloudkitchen.kafka.topic;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "docker.for.mac.localhost:9092");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicExample() {
        return TopicBuilder.name("orders-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicExample2() {
        return TopicBuilder.name("orders-topic-test")
                .partitions(5)
                .replicas(2)
                .build();
    }
}