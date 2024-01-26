package com.group1.service;


import com.group1.dto.request.SpendingRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.SpendingMapper;
import com.group1.repository.SpendingRepository;
import com.group1.repository.entity.Personel;
import com.group1.repository.entity.Spending;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final PersonelService personelService;



        public Optional<Spending> createSpending(SpendingRequestDto spendingRequestDto){

            // SpendingRequestDto'dan Spending entity'sine dönüştürme
            Spending spending = SpendingMapper.INSTANCE.toSpending(spendingRequestDto);

            // Personel entity'sini çekme
            String personelId =spendingRequestDto.getPersonelId();
            Optional<Personel> personel =personelService.findById(personelId);

            // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
            if (personel == null) {
                throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
            }

            // Spending entity'sine personel bilgisini set etme
            spending.setPersonelId(personelId);

            // Diğer işlemleri gerçekleştirme ve harcamayı kaydetme
            // ...
            return Optional.of(spendingRepository.save(spending));
        }
    }

