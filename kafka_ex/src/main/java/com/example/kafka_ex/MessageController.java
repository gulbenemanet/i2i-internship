package com.example.kafka_ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
    @Autowired
    private MessagePublisher messagePublisher;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody OperationMessage message) {
        messagePublisher.sendMessage(message);
        return "Message published";
    }
}
