package com.group1.rabbitmq.consumer;

import com.group1.dto.request.PersonelSaveRequestDto;
import com.group1.rabbitmq.model.ManagerRegisterModel;
import com.group1.rabbitmq.model.RegisterModel;
import com.group1.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerRegisterConsumer {
    private final ManagerService managerService;

    @RabbitListener(queues = "queue-manager-create-personel")
    public void createNewManager(ManagerRegisterModel model){
        System.out.println("Kuyruk dinlendi gelen kayıt."+ model.toString());
        managerService.save(PersonelSaveRequestDto.builder()
                .email(model.getEmail())
                .password(model.getPassword())
                .build());
    }
}
