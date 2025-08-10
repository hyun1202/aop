package com.example.demo.config;

import com.example.demo.producer.DefaultProducerService;
import com.example.demo.producer.KafkaService;
import com.example.demo.producer.ProducerService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    @ConditionalOnProperty(prefix = "producer", name = "type", havingValue = "kafka")
    public ProducerService producerService() {
        return new KafkaService();
    }

    @Bean
    @ConditionalOnProperty(
            prefix = "producer",
            name = "type",
            havingValue = "none",
            matchIfMissing = true  // 프로퍼티가 없을 때도 기본값으로 사용
    )
    public ProducerService defaultProducerService() {
        return new DefaultProducerService();
    }
}
