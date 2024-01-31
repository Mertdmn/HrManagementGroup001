package com.group1.service;


import com.group1.dto.request.SpendingRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.SpendingMapper;
import com.group1.repository.SpendingRepository;
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
        public Optional<Spending> createSpending(SpendingRequestDto spendingRequestDto){
            Optional<Long> personelId=jwtTokenManager.getIdFromToken(spendingRequestDto.getToken());
            if (personelId.isEmpty()) {
                throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
            }
            // SpendingRequestDto'dan Spending entity'sine dönüştürme
            Spending spending = SpendingMapper.INSTANCE.toSpending(spendingRequestDto);
            spending.setState(EState.PENDING);
            // Personel entity'sini çekme
            Optional<Personel> personel =personelService.findOptionalById(personelId.get());

            // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
            if (personel == null) {
                throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
            }
            // Spending entity'sine personel bilgisini set etme

            // Diğer işlemleri gerçekleştirme ve harcamayı kaydetme
            // ...
            return Optional.of(spendingRepository.save(spending));
        }
    }

