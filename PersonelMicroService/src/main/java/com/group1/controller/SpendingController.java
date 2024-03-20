package com.group1.controller;





import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.request.SpendingRequestDto;
import com.group1.dto.response.ShowItemsResponseDto;
import com.group1.dto.response.ShowSpendingResponseDto;
import com.group1.repository.entity.Spending;
import com.group1.service.SpendingService;
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
@RequestMapping(SPENDING)
public class SpendingController {
    private final SpendingService spendingService;

    @PostMapping(CREATE)
    public ResponseEntity<Optional<Spending>> createSpending(SpendingRequestDto dto){
        return ResponseEntity.ok(spendingService.createSpending(dto));
    }
    @GetMapping(SHOW)
    public ResponseEntity<Spending> showPersonelByToken(GetPersonelByTokenRequestDto dto){
        return ResponseEntity.ok(spendingService.showSpendingByToken(dto));
    }

}
