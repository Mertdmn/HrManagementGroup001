package com.group1.controller;

import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.request.ItemsRequestDto;
import com.group1.dto.response.ShowAdvanceResponseDto;
import com.group1.dto.response.ShowItemsResponseDto;
import com.group1.repository.entity.Items;
import com.group1.service.ItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ITEMS)
public class ItemsController {
    private final ItemsService itemsService;
    @PostMapping(CREATE)
    public ResponseEntity<Optional<Items>>createItems(@RequestBody @Valid ItemsRequestDto dto){
        return ResponseEntity.ok(itemsService.createItems(dto));
    }
    @GetMapping(SHOW)
    public ResponseEntity<ShowItemsResponseDto> showPersonelByToken(GetPersonelByTokenRequestDto dto){
        return ResponseEntity.ok(itemsService.showAdvanceByToken(dto));
    }



}
