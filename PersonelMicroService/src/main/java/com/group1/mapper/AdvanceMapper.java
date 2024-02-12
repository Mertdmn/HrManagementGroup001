package com.group1.mapper;


import com.group1.dto.request.AdvanceRequestDto;
import com.group1.dto.response.ShowAdvanceResponseDto;
import com.group1.repository.entity.Advance;
import com.group1.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface AdvanceMapper {
    AdvanceMapper INSTANCE = Mappers.getMapper(AdvanceMapper.class);

    Advance toAdvance(final AdvanceRequestDto advance);

    ShowAdvanceResponseDto toShow(Advance advance);
}
