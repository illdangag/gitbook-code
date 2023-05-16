package com.illdangag.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.illdangag.kafka.service.KafkaProducer;

@RestController
@RequestMapping(value = "/send")
public class SampleController {
    private final KafkaProducer producer;

    @Autowired
    public SampleController(KafkaProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/00")
    public ResponseEntity<String> send00(@RequestParam(name = "message", defaultValue = "", required = false) String message) {
        producer.sendMessage00(message);

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/01")
    public ResponseEntity<String> send01(@RequestParam(name = "message", defaultValue = "", required = false) String message) {
        producer.sendMessage01(message);

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
