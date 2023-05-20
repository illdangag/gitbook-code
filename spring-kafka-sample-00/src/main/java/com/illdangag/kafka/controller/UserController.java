package com.illdangag.kafka.controller;

import com.illdangag.kafka.data.User;
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
public class UserController {
    private final KafkaProducer producer;

    @Autowired
    public UserController(KafkaProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ResponseEntity<String> send00(@RequestParam(name = "name", defaultValue = "", required = false) String name,
                                         @RequestParam(name = "age", defaultValue = "", required = false) int age) {
        User user = new User(name, age);
        producer.sendMessage(user);

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
