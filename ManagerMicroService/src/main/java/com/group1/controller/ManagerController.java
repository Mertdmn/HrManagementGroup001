package com.group1.controller;

import com.group1.dto.request.*;
import com.group1.dto.response.*;
import com.group1.repository.entity.Manager;
import com.group1.service.ManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MANAGER)
public class ManagerController {
    private final ManagerService managerService;

//    @GetMapping(SHOW)
//    public ResponseEntity<Optional<ShowResponseDto>> show(){
//        return ResponseEntity.ok(managerService.show());
//    }
//    @PostMapping(UPDATE)
//    public ResponseEntity<Void> update(UpdateRequestDto dto) {
//        managerService.update(dto);
//        return ResponseEntity.ok().build();
//    }
//    @GetMapping(SHOWDETAILS)
//    public ResponseEntity<Optional<ManagerResponseDto>> showDetails(){
//        return ResponseEntity.ok(managerService.showDetails());
//    }
//    @PostMapping(LOGIN)
//    public ResponseEntity<Boolean> login(@RequestBody LoginManagerRequestDto dto) {
//        return ResponseEntity.ok(managerService.login(dto));
//    }
@PostMapping(REGISTER)
@CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<RegisterResponseDto>> register(@RequestBody @Valid RegisterRequestDto dto){
        managerService.register(dto);
        return ResponseEntity.ok(BaseResponseDto.<RegisterResponseDto>builder()
                .responseCode(200)
                .data(RegisterResponseDto.builder()
                        .isRegister(true)
                        .message("Üyelik Başarı ile gerçekleşti")
                        .build())
                .build());
    }
    @PostMapping("/save")
    public ResponseEntity<Void> save(RegisterManagerRequestDto dto){
        Manager manager =managerService.save(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody LoginManagerRequestDto dto) {
        String token=managerService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                .responseCode(200)
                .data(LoginResponseDto.builder()
                        .isLogin(true)
                        .token(token)
                        .build())
                .build());
    }
    @GetMapping(SHOW)
    public ResponseEntity<ShowResponseDto> showAdminByToken(GetManagerByTokenRequestDto dto){
        return ResponseEntity.ok(managerService.showAdminByToken(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdateRequestDto dto) {
        managerService.update(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(SHOWDETAILS)
    public ResponseEntity<ManagerResponseDto> showDetails(GetManagerByTokenRequestDto dto){
        return ResponseEntity.ok(managerService.showDetailsPersonelByToken(dto));
    }
}

