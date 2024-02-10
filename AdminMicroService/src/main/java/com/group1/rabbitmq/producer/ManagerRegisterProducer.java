package com.group1.rabbitmq.producer;

import com.group1.rabbitmq.model.ManagerRegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerRegisterProducer {
    private final RabbitTemplate rabbitTemplate;
    public void sendNewManager(ManagerRegisterModel model){
        rabbitTemplate.convertAndSend("exchange-manager","key-manager",model);

    }

}
