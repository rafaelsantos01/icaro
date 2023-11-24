package com.mail.icaro.shared.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Service;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

//@Service
public class KafkaConsumerConfig {

   // @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServerUrl;

    @Bean
    public ConsumerFactory<String, Object> ConsumerFactory() {
        Map<String, Object> configs = new HashMap<>();

        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "icaro");

        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerUrl);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> ContainerFactory(
            ConsumerFactory<String, Object> ConsumerFactory
    ) {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(ConsumerFactory);
       factory.setMessageConverter(new JsonMessageConverter());
        return factory;
    }
}
