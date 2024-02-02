package com.group1.controller;


import com.group1.dto.request.*;
import com.group1.dto.response.BaseResponseDto;
import com.group1.dto.response.LoginResponseDto;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import com.group1.service.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody LoginPersonelRequestDto dto) {
        String token=personelService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                .responseCode(200)
                .data(LoginResponseDto.builder()
                        .isLogin(true)
                        .token(token)
                        .build())
                .build());
    }
    @GetMapping(SHOW)
    public ResponseEntity<ShowResponseDto> showPersonelByToken(GetPersonelByTokenRequestDto dto){
        return ResponseEntity.ok(personelService.showPersonelByToken(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdatePersonelRequestDto dto) {
        personelService.update(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid PersonelSaveRequestDto dto){
        Personel personel =   personelService.save(dto);
        return ResponseEntity.ok().build();
    }
@GetMapping(SHOWDETAILS)
public ResponseEntity<PersonelResponseDto> showDetails(GetPersonelDetailsByTokenRequestDto dto){
    return ResponseEntity.ok(personelService.showDetailsPersonelByToken(dto));
}
}
