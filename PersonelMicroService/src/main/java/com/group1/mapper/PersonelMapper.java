package com.group1.mapper;


import com.group1.dto.response.RegisterResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PersonelMapper {
    PersonelMapper INSTANCE = Mappers.getMapper(PersonelMapper.class);

    /**
     * MultiPart files Mapper ile Gönderilemiyor..
     * @param personel
     * @return
     */
//    Personel fromRegisterRequestToPersonel(RegisterRequestDto dto);
    ShowResponseDto toShow(final Personel personel);


    RegisterResponseDto fromPersonelToRegisterResponse(Personel personel);

    Personel toShowDetails(final Personel personel);
}
