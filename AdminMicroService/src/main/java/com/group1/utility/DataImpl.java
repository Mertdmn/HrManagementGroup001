package com.group1.utility;

import com.group1.repository.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        createAdmin();
    }

    private void createAdmin() {

        Admin admin = Admin.builder()
                .email("mert.duman@bilgeadam.com")
                .name("Mert")
                .surname("Duman")
                .password("123")
                .phone("123")
                .build();
        Admin admin1 = Admin.builder()
                .email("furkan.balbaşıo@bilgeadam.com")
                .name("Furkan")
                .surname("Balbasio")
                .password("123")
                .phone("123")
                .build();
        Admin admin2 = Admin.builder()
                .email("atakan.tashan@bilgeadam.com")
                .name("Atakan")
                .surname("Tashanlioglu")
                .password("123")
                .phone("123")
                .build();
    }
}
