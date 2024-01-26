package com.group1.controller;

import com.group1.dto.request.ItemConfirmRequestDto;
import com.group1.dto.request.ItemsRequestDto;
import com.group1.dto.response.FindAllItemResponseDto;
import com.group1.dto.response.ItemConfirmResponseDto;
import com.group1.dto.response.ItemsResponseDto;
import com.group1.repository.entity.Items;
import com.group1.service.ItemsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.group1.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ITEMS)
public class ItemsController {
    private final ItemsService itemsService;
    @PostMapping(CREATE)
    public ResponseEntity<ItemsResponseDto>createItems(@RequestBody @Valid ItemsRequestDto dto){
        return ResponseEntity.ok(itemsService.createItems(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Items>>findAllItems(){
        return ResponseEntity.ok(itemsService.findAllItems());
    }

    @GetMapping(CONFIRM)
    public ResponseEntity<ItemConfirmResponseDto>itemConfirm(ItemConfirmRequestDto dto){
        return ResponseEntity.ok(itemsService.confirmItems(dto));
    }


}
