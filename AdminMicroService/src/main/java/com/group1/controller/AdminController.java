package com.group1.controller;

import com.group1.dto.request.GetAdminByTokenRequestDto;
import com.group1.dto.request.GetAdminDetailsByTokenRequestDto;
import com.group1.dto.request.LoginAdminRequestDto;
import com.group1.dto.request.UpdateAdminRequestDto;
import com.group1.dto.response.AdminResponseDto;
import com.group1.dto.response.BaseResponseDto;
import com.group1.dto.response.LoginResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.group1.constants.RestApiUrls.*;
import static com.group1.constants.RestApiUrls.SHOWDETAILS;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;

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

