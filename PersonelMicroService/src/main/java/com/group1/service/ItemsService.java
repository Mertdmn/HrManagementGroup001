package com.group1.service;

import com.group1.dto.request.ItemsRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.ItemsMapper;
import com.group1.repository.ItemsRepository;
import com.group1.repository.entity.Items;
import com.group1.repository.entity.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final PersonelService personelService;


    public Optional<Items> createItems(ItemsRequestDto dto) {
        Items items = ItemsMapper.INSTANCE.fromCreateItemsRequestDto(dto);

        String personelId = dto.getPersonelId();
        Optional<Personel> personel = personelService.findById(personelId);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        items.setPersonelId(personelId);
        return Optional.of(itemsRepository.save(items));
    }
}
