package com.group1.rabbitmq.producer;

import com.group1.rabbitmq.model.RegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProducer {
    @Value("${rabbitmq.exchange-auth}")
    private String directExchange;

    @Value("${rabbitmq.register-key}")
    private String registerBindingKey;
    private final RabbitTemplate rabbitTemplate;
    public void sendNewUser(RegisterModel model){
        rabbitTemplate.convertAndSend(directExchange,registerBindingKey,model);
    }
}
