package com.illdangag.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "TOPIC_00", groupId = "SERVER00")
    public void consume00(String message) throws IOException {
        log.info("Consumed message(TOPIC_00): {}", message);
    }

    @KafkaListener(topics = "TOPIC_01", groupId = "SERVER00")
    public void consume01(String message) throws IOException {
        log.info("Consumed message(TOPIC_01): {}", message);
    }
}
