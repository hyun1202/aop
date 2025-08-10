package com.example.demo.producer;

public class KafkaService implements ProducerService {
    @Override
    public void send(String message) {
        System.out.println("kafka send message: " + message);
    }
}
