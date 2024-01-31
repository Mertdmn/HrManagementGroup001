package com.group1.rabbitmq.consumer;

import com.group1.dto.request.RegisterRequestDto;
import com.group1.rabbitmq.model.RegisterModel;
import com.group1.service.PersonelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j //Console'a log ciktisi vermek icin kullanilan bir kutuphane
public class RegisterConsumer {

    private final PersonelService personelService;

    @RabbitListener(queues = "${rabbitmq.queue-register}") //register-queue
    public void createNewPersonel(RegisterModel model){
        System.out.println("Kuyruk dinlendi gelen kayıt."+ model.toString());
        personelService.save(RegisterRequestDto.builder()
                        .email(model.getEmail())
                        .password(model.getPassword())
                        .managerId(model.getManagerId())
                .build());
    }



}
