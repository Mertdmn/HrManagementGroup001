package com.group1.service;

import com.group1.dto.request.ItemsRequestDto;
import com.group1.exception.ErrorType;
import com.group1.exception.PersonelManagerException;
import com.group1.mapper.ItemsMapper;
import com.group1.repository.ItemsRepository;
import com.group1.repository.entity.Items;
import com.group1.repository.entity.Personel;
import com.group1.utility.enums.EState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.group1.service.PersonelService.loginUser;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    private final PersonelService personelService;


    public Optional<Items> createItems(ItemsRequestDto dto) {
        Items items = ItemsMapper.INSTANCE.fromCreateItemsRequestDto(dto);
        items.setState(EState.PENDING);
        Optional<Personel> personel = personelService.findById(loginUser);
        if (personel == null) {
            throw new PersonelManagerException(ErrorType.PERSONEL_NOT_FOUND);
        }
        return Optional.of(itemsRepository.save(items));
    }
}
