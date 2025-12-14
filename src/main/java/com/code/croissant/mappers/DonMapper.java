package com.code.croissant.mappers;

import com.code.croissant.DTO.DonDto;
import com.code.croissant.model.Don;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonMapper {

    DonDto toDonDto(Don don);
}
