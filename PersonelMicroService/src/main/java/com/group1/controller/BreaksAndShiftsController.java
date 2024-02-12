package com.group1.controller;

import com.group1.dto.request.BreaksRequestDto;
import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.request.ShiftRequestDto;
import com.group1.dto.response.ShowAdvanceResponseDto;
import com.group1.dto.response.ShowBreaksAndShiftsResponseDto;
import com.group1.repository.entity.BreaksAndShifts;
import com.group1.service.BreaksAndShiftsService;
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
@RequestMapping(BREAKSANDSHIFTS)
public class BreaksAndShiftsController {
    private final BreaksAndShiftsService breaksAndShiftsService;
    @PostMapping(CREATEBREAKS)
    public ResponseEntity<Optional<BreaksAndShifts>> createBreaks(BreaksRequestDto dto){
        return ResponseEntity.ok(breaksAndShiftsService.createBreaks(dto));
    }
    @PostMapping(CREATESHIFTS)
    public ResponseEntity<Optional<BreaksAndShifts>> createBreaks(ShiftRequestDto dto){
        return ResponseEntity.ok(breaksAndShiftsService.createShifts(dto));
    }
    @GetMapping(SHOW)
    public ResponseEntity<ShowBreaksAndShiftsResponseDto> showPersonelByToken(GetPersonelByTokenRequestDto dto){
        return ResponseEntity.ok(breaksAndShiftsService.showAdvanceByToken(dto));
    }
}
