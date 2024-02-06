package com.group1.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String EXCHANGE_AUTH = "exchange-manager";
    private final String BIDING_KEY = "key-manager";
    private final String AUTH_QUEUE = "queue-manager-create-personel";
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_AUTH);
    }
    @Bean
    Queue queueAuthCreateUser(){
        return new Queue(AUTH_QUEUE);
    }
    @Bean
    public Binding bindingCreateUser(final DirectExchange directExchange, final Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(BIDING_KEY);
    }

}
