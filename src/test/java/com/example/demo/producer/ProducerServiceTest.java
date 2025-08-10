package com.example.demo.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerServiceTest {
    @Autowired
    ProducerService producerService;

    @Test
    public void test() {
        producerService.send("hello");
    }
}