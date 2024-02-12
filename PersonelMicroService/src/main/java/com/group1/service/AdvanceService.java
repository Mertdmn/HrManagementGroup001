package com.group1.service;



import com.group1.dto.request.AdvanceRequestDto;
import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.response.ShowAdvanceResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.AdvanceMapper;
import com.group1.mapper.PersonelMapper;
import com.group1.repository.AdvanceRepository;
import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;
private final JwtTokenManager jwtTokenManager;
private final PersonelService personelService;

    public Optional<Advance> createAdvance(AdvanceRequestDto advanceRequestDto) {

        Optional<Long> personelId=jwtTokenManager.getIdFromToken(advanceRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }

        Optional<Personel> personel=personelService.findOptionalById(personelId.get());
        if (personel.isEmpty()){
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        // SpendingRequestDto'dan Spending entity'sine dönüştürme
        Advance advance = AdvanceMapper.INSTANCE.toAdvance(advanceRequestDto);
        advance.setState(EState.PENDING);
        // Personel entity'sini çekme

        // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.

        // Spending entity'sine personel bilgisini set etme
        // Diğer işlemleri gerçekleştirme ve avans kaydetme
        return Optional.of(advanceRepository.save(advance));
    }
    public ShowAdvanceResponseDto showAdvanceByToken(GetPersonelByTokenRequestDto getPersonelByTokenRequestDto) {
        Optional<Long> advanceId=jwtTokenManager.getIdFromToken(getPersonelByTokenRequestDto.getToken());
        if (advanceId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<Advance> advance=advanceRepository.findOptionalById(advanceId.get());
        if (advance.isEmpty()) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return AdvanceMapper.INSTANCE.toShow(advance.get());
    }

}
