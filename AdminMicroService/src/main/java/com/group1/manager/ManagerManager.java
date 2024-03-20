package com.group1.manager;

import com.group1.dto.request.ManagerSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:9091/manager",name = "managerManager")
public interface ManagerManager {
        @PostMapping("/save")
        ResponseEntity<Void> save(ManagerSaveRequestDto dto);
}
