package com.group1.service;

import com.group1.dto.request.BreaksRequestDto;
import com.group1.dto.request.PermissionRequestDto;
import com.group1.dto.request.ShiftRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.BreaksAndShiftsMapper;
import com.group1.mapper.PermissionsMapper;
import com.group1.repository.BreaksAndShiftsRepository;
import com.group1.repository.entity.BreaksAndShifts;
import com.group1.repository.entity.Permissions;
import com.group1.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BreaksAndShiftsService {
    private final BreaksAndShiftsRepository breaksAndShiftsRepository;
    private final PersonelService personelService;
    public Optional<BreaksAndShifts> createBreaks(BreaksRequestDto breaksRequestDto) {

        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toBreaks(breaksRequestDto);

        String personelId = breaksRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        breaksAndShifts.setPersonelId(personelId);
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }
    public Optional<BreaksAndShifts> createShifts(ShiftRequestDto shiftRequestDto) {

        BreaksAndShifts breaksAndShifts = BreaksAndShiftsMapper.INSTANCE.toShifts(shiftRequestDto);

        String personelId = shiftRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        breaksAndShifts.setPersonelId(personelId);
        return Optional.of(breaksAndShiftsRepository.save(breaksAndShifts));
    }

}
