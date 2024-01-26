package com.group1.mapper;


import com.group1.dto.request.BreaksRequestDto;
import com.group1.dto.request.ShiftRequestDto;
import com.group1.repository.entity.BreaksAndShifts;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BreaksAndShiftsMapper {
    BreaksAndShiftsMapper INSTANCE= Mappers.getMapper(BreaksAndShiftsMapper.class);
    BreaksAndShifts toBreaks(final BreaksRequestDto breaksRequestDto);
    BreaksAndShifts toShifts(final ShiftRequestDto shift);
}
