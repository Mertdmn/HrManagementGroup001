package com.group1.controller;

import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.UpdateRequestDto;
import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Manager;
import com.group1.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MANAGER)
public class ManagerController {
    private final ManagerService managerService;
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(LoginPersonelRequestDto dto) {
        return ResponseEntity.ok(managerService.login(dto));
    }
    @GetMapping(SHOW)
    public ResponseEntity<Optional<ShowResponseDto>> show(){
        return ResponseEntity.ok(managerService.show());
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdateRequestDto dto) {
        managerService.update(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(SHOWDETAILS)
    public ResponseEntity<Optional<ManagerResponseDto>> showDetails(){
        return ResponseEntity.ok(managerService.showDetails());
    }
}

