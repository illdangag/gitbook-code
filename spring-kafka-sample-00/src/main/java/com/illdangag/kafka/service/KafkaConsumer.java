package com.illdangag.kafka.service;

import com.illdangag.kafka.data.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "User", groupId = "user-group")
    public void consume(User user) throws IOException {
        log.info("Consume: {}", user.toString());
    }
}
