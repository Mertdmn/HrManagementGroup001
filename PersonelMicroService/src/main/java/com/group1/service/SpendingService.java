package com.group1.service;


import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.request.SpendingRequestDto;
import com.group1.dto.response.ShowItemsResponseDto;
import com.group1.dto.response.ShowSpendingResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.ItemsMapper;
import com.group1.mapper.PermissionsMapper;
import com.group1.mapper.SpendingMapper;
import com.group1.repository.PersonelRepository;
import com.group1.repository.SpendingRepository;
import com.group1.repository.entity.Items;
import com.group1.repository.entity.Permissions;
import com.group1.repository.entity.Personel;
import com.group1.repository.entity.Spending;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final PersonelService personelService;
    private final JwtTokenManager jwtTokenManager;
    private final PersonelRepository personelRepository;
        public Optional<Spending> createSpending(SpendingRequestDto spendingRequestDto){
            Optional<Long> personelId=jwtTokenManager.getIdFromToken(spendingRequestDto.getToken());
            if (personelId.isEmpty()) {
                throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
            }
            Spending spending = SpendingMapper.INSTANCE.toSpending(spendingRequestDto);
            spending.setState(EState.PENDING);
            Optional<Personel> personel = personelService.findOptionalById(personelId.get());
            if (personel == null) {
                throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
            }
            return Optional.of(spendingRepository.save(spending));
        }



    public Spending showSpendingByToken(GetPersonelByTokenRequestDto dto) {
       Optional<Long> personelId=personelService.tokenToId(dto);
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Spending> spending=spendingRepository.findOptionalById(personelId.get());
        if (spending.isEmpty()) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Spending.builder()
                .file(spending.get().getFile())
                .description(spending.get().getDescription())
                .personelId(personelId.get())
                .currency(spending.get().getCurrency())
                .state(spending.get().getState())
                .requestDate(spending.get().getRequestDate())
                .build();
    }
    }


