package com.group1.service;

import com.group1.dto.request.BreaksRequestDto;
import com.group1.dto.request.GetPersonelByTokenRequestDto;
import com.group1.dto.request.ShiftRequestDto;
import com.group1.dto.response.ShowAdvanceResponseDto;
import com.group1.dto.response.ShowBreaksAndShiftsResponseDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.AdvanceMapper;
import com.group1.mapper.BreaksAndShiftsMapper;
import com.group1.repository.BreaksAndShiftsRepository;
import com.group1.repository.entity.Advance;
import com.group1.repository.entity.BreaksAndShifts;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BreaksAndShiftsService {
    private final BreaksAndShiftsRepository breaksAndShiftsRepository;
    private final PersonelService personelService;
    private final JwtTokenManager jwtTokenManager;
    public Optional<BreaksAndShifts> createBreaks(BreaksRequestDto breaksRequestDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(breaksRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toBreaks(breaksRequestDto);
        breaksAndShifts.setState(EState.PENDING);
        Optional<Personel> personel = personelService.findOptionalById(personelId.get());
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }
    public Optional<BreaksAndShifts> createShifts(ShiftRequestDto shiftRequestDto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(shiftRequestDto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toShifts(shiftRequestDto);
        breaksAndShifts.setState(EState.PENDING);
        Optional<Personel> personel = personelService.findOptionalById(personelId.get());
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }
        public ShowBreaksAndShiftsResponseDto showAdvanceByToken(GetPersonelByTokenRequestDto getPersonelByTokenRequestDto) {
        Optional<Long> breaksAndShiftsId=jwtTokenManager.getIdFromToken(getPersonelByTokenRequestDto.getToken());
        if (breaksAndShiftsId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<BreaksAndShifts> breaksAndShifts=breaksAndShiftsRepository.findOptionalById(breaksAndShiftsId.get());
        if (breaksAndShifts.isEmpty()) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return BreaksAndShiftsMapper.INSTANCE.toShow(breaksAndShifts.get());
    }

}
