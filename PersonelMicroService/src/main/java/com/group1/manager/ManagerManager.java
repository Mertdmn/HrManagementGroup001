package com.group1.manager;

import com.group1.dto.request.RegisterRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "manager-manager", url = "http://localhost:9091/manager")
public interface ManagerManager {
    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody RegisterRequestDto dto);
}
