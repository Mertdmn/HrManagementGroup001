package com.group1.controller;

import com.group1.dto.request.*;
import com.group1.dto.response.*;
import com.group1.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;
    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<RegisterResponseDto>> register(RegisterRequestDto dto){
        adminService.register(dto);
        return ResponseEntity.ok(BaseResponseDto.<RegisterResponseDto>builder()
                .responseCode(200)
                .data(RegisterResponseDto.builder()
                        .isRegister(true)
                        .message("Üyelik Başarı ile gerçekleşti")
                        .build())
                .build());
    }
    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody LoginAdminRequestDto dto) {
        String token=adminService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                .responseCode(200)
                .data(LoginResponseDto.builder()
                        .isLogin(true)
                        .token(token)
                        .build())
                .build());
    }
    @GetMapping(SHOW)
    public ResponseEntity<ShowResponseDto> showAdminByToken(GetAdminByTokenRequestDto dto){
        return ResponseEntity.ok(adminService.showAdminByToken(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdateAdminRequestDto dto) {
        adminService.update(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(SHOWDETAILS)
    public ResponseEntity<AdminResponseDto> showDetails(GetAdminDetailsByTokenRequestDto dto){
        return ResponseEntity.ok(adminService.showDetailsPersonelByToken(dto));
    }
}

