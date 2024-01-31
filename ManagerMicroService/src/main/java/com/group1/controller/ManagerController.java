package com.group1.controller;

import com.group1.dto.request.LoginManagerRequestDto;
import com.group1.dto.request.RegisterRequestDto;
import com.group1.dto.request.UpdateRequestDto;
import com.group1.dto.response.BaseResponseDto;
import com.group1.dto.response.ManagerResponseDto;
import com.group1.dto.response.RegisterResponseDto;
import com.group1.dto.response.ShowResponseDto;
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

}

