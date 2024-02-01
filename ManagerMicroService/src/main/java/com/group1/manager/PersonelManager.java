package com.group1.manager;

import com.group1.dto.request.RegisterRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "personel-manager", url = "http://localhost:9090/personel")
public interface PersonelManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody RegisterRequestDto dto);
}
