package com.example.demo.producer;

public class DefaultProducerService implements ProducerService {
    @Override
    public void send(String message) {
        System.out.println("default producer " + message);
    }
}
