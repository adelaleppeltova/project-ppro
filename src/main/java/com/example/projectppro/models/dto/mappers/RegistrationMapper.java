package com.example.projectppro.models.dto.mappers;

import com.example.projectppro.data.entities.RegistrationEntity;
import com.example.projectppro.models.dto.RegistrationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    RegistrationEntity toEntity(RegistrationDTO source);

    @Mapping(target = "competitionId", source = "competition.Id")
    @Mapping(target = "userId", source = "user.Id")
    RegistrationDTO toDTO(RegistrationEntity source);

    void updateRegistrationDTO(RegistrationDTO source, @MappingTarget RegistrationDTO target);

    void updateReservationEntity(RegistrationDTO source, @MappingTarget RegistrationEntity target);
}
