package com.group1.service;

import com.group1.dto.request.ItemsRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.ItemsMapper;
import com.group1.repository.ItemsRepository;
import com.group1.repository.entity.Items;
import com.group1.repository.entity.Personel;
import com.group1.utility.JwtTokenManager;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final PersonelService personelService;
    private final JwtTokenManager jwtTokenManager;

    public Optional<Items> createItems(ItemsRequestDto dto) {
        Optional<Long> personelId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (personelId.isEmpty()) {
            throw new PersonelManagerException(ErrorType.INVALID_TOKEN);
        }
        Items items = ItemsMapper.INSTANCE.fromCreateItemsRequestDto(dto);
        items.setState(EState.PENDING);
        Optional<Personel> personel = personelService.findOptionalById(personelId.get());
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(itemsRepository.save(items));
    }
}
