package com.group1.service;



import com.group1.dto.request.AdvanceRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.AdvanceMapper;
import com.group1.repository.AdvanceRepository;
import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;

private final PersonelService personelService;
   /* public Optional<Advance> createAdvance(AdvanceRequestDto dto) {

        Advance advance = AdvanceMapper.INSTANCE.toAdvanceRequestDto(dto);
        dto.setState(EState.PENDING);
        dto.setPersonelId(personelService.findByPersonelId(dto.getPersonelId()));
        advanceRepository.save(advance);
=========
    public Optional<Advance> createAdvance(AdvanceRequestDto dto){
        return Optional.empty();
>>>>>>>>> Temporary merge branch 2
    }

    public void addAdvanceForPersonel(AddAdvanceForPersonelRequestDto dto){
        if(!personelService.existsById(dto.getPersonelId()) || !PersonelService.isPersonel(dto.getPersonelId()))
            throw new PersonelManagerException(ErrorType.ADVANCE_NOT_FOUND);

    }*/

    public Optional<Advance> createAdvance(AdvanceRequestDto advanceRequestDto) {


        // SpendingRequestDto'dan Spending entity'sine dönüştürme
        Advance advance = AdvanceMapper.INSTANCE.toAdvance(advanceRequestDto);

        // Personel entity'sini çekme
        String personelId = advanceRequestDto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);

        // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        // Spending entity'sine personel bilgisini set etme
        advance.setPersonelId(personelId);

        // Diğer işlemleri gerçekleştirme ve avans kaydetme
        return Optional.of(advanceRepository.save(advance));
    }



}
