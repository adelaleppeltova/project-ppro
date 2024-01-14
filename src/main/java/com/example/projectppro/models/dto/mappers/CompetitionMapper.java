package com.example.projectppro.models.dto.mappers;

import com.example.projectppro.data.entities.CompetitionEntity;
import com.example.projectppro.models.dto.CompetitionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionEntity toEntity(CompetitionDTO source);

    CompetitionDTO toDTO(CompetitionEntity source);

    void updateCompetitionDTO(CompetitionDTO source, @MappingTarget CompetitionDTO target);

    void updateCompetitionEntity(CompetitionDTO source, @MappingTarget CompetitionEntity target);
}
