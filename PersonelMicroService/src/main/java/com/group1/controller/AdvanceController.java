package com.group1.controller;



import com.group1.dto.request.AdvanceRequestDto;
import com.group1.repository.entity.Advance;
import com.group1.service.AdvanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(ADVANCE)
public class AdvanceController {
    private final AdvanceService advanceService;

    @PostMapping(CREATE)
    public ResponseEntity<Optional<Advance>> createAdvance(AdvanceRequestDto dto){
        return ResponseEntity.ok(advanceService.createAdvance(dto));
    }


}
