package com.example.projectppro.models.services;


import com.example.projectppro.data.entities.CompetitionEntity;
import com.example.projectppro.data.repositories.CompetitionRepository;
import com.example.projectppro.models.dto.CompetitionDTO;
import com.example.projectppro.models.dto.mappers.CompetitionMapper;
import com.example.projectppro.models.exceptions.CompetitionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public void create(CompetitionDTO competition) {
        CompetitionEntity newCompetition = competitionMapper.toEntity(competition);
        competitionRepository.save(newCompetition);
    }

    @Override
    public List<CompetitionDTO> getAll() {
        return competitionRepository.getAllByIsDeleted(false).stream()
                .map(i -> competitionMapper.toDTO(i))
                .toList();
    }

    @Override
    public CompetitionDTO getById(long competitionId) {
        CompetitionEntity selectedCompetition = getCompetitionOrThrow(competitionId);
        return competitionMapper.toDTO(selectedCompetition);
    }

    @Override
    public void edit(CompetitionDTO competition) {
        CompetitionEntity selectedCompetition = getCompetitionOrThrow(competition.getCompetitionId());

        competitionMapper.updateCompetitionEntity(competition, selectedCompetition);
        competitionRepository.save(selectedCompetition);
    }

    @Override
    public void remove(long competitionId) {
        CompetitionEntity selectedCompetition = getCompetitionOrThrow(competitionId);
        selectedCompetition.setDeleted(true);
        competitionRepository.save(selectedCompetition);
    }

    @Override
    public List<CompetitionDTO> getAllAvailableForReservation(LocalDate date) {
        return competitionRepository.findAvailableCompetitionsForDate(date).stream()
                .map(i -> competitionMapper.toDTO(i))
                .toList();
    }

    public CompetitionEntity getCompetitionOrThrow(long competitionId) {
        return competitionRepository
                .findById(competitionId)
                .orElseThrow(CompetitionNotFoundException::new);
    }
}
