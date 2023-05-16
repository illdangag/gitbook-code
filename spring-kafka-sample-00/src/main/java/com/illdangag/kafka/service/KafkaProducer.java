package com.illdangag.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage00(String message) {
        log.info("Produce message(TOPIC_00): {}", message);
        this.kafkaTemplate.send("TOPIC_00", message);
    }

    public void sendMessage01(String message) {
        log.info("Produce message(TOPIC_01): {}", message);
        this.kafkaTemplate.send("TOPIC_01", message);
    }
}
