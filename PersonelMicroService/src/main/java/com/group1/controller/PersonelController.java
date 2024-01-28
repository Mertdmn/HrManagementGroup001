package com.group1.controller;


import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.RegisterRequestDto;
import com.group1.dto.request.UpdatePersonelRequestDto;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.RegisterResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import com.group1.service.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONEL)
public class PersonelController {
    private final PersonelService personelService;

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(LoginPersonelRequestDto dto) {
        return ResponseEntity.ok(personelService.login(dto));
    }
    @GetMapping(SHOW)
    public ResponseEntity<Optional<ShowResponseDto>> show(){
        return ResponseEntity.ok(personelService.show());
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdatePersonelRequestDto dto) {
        personelService.update(dto);
        return ResponseEntity.ok().build();
    }
@GetMapping(SHOWDETAILS)
public ResponseEntity<Optional<PersonelResponseDto>> showDetails(){
    return ResponseEntity.ok(personelService.showDetails());
}
}
