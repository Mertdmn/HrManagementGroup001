package com.group1.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String EXCHANGE_MANAGER = "exchange-manager";
    private final String BINDING_KEY = "key-manager";
    private final String MANAGER_QUEUE = "queue-manager-create-personel";
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_MANAGER);
    }
    @Bean
    Queue queueAuthCreateUser(){
        return new Queue(MANAGER_QUEUE);
    }
    @Bean
    public Binding bindingCreateUser(final DirectExchange directExchange, final Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(BINDING_KEY);
    }

}
