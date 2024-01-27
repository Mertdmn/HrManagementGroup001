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

import static com.group1.service.PersonelService.loginUser;

@Service
@RequiredArgsConstructor
public class AdvanceService {
    private final AdvanceRepository advanceRepository;

private final PersonelService personelService;

    public Optional<Advance> createAdvance(AdvanceRequestDto advanceRequestDto) {


        // SpendingRequestDto'dan Spending entity'sine dönüştürme
        Advance advance = AdvanceMapper.INSTANCE.toAdvance(advanceRequestDto);

        // Personel entity'sini çekme
        Optional<Personel> personel = personelService.findById(loginUser);

        // Eğer personel bulunamazsa, gerekli hata işlemlerini yapabilirsiniz.
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }

        // Spending entity'sine personel bilgisini set etme

        // Diğer işlemleri gerçekleştirme ve avans kaydetme
        return Optional.of(advanceRepository.save(advance));
    }

}
