package com.group1.mapper;



import com.group1.dto.request.SpendingRequestDto;
import com.group1.repository.entity.Spending;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpendingMapper {
    SpendingMapper INSTANCE = Mappers.getMapper(SpendingMapper.class);
    Spending toSpending(final SpendingRequestDto spending);

}
