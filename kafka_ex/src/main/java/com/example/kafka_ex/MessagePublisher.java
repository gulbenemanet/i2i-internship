package com.example.kafka_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    @Autowired
    private KafkaTemplate<String, OperationMessage> kafkaTemplate;

    private static final String TOPIC = "operation_topic";

    public void sendMessage(OperationMessage message) {
        kafkaTemplate.send(TOPIC, message);
    }
}