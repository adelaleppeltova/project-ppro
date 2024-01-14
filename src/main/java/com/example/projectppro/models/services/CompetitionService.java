package com.example.projectppro.models.services;


import com.example.projectppro.models.dto.CompetitionDTO;

import java.time.LocalDate;
import java.util.List;

public interface CompetitionService {
    void create(CompetitionDTO car);

    List<CompetitionDTO> getAll();

    CompetitionDTO getById(long carId);

    void edit(CompetitionDTO car);

    void remove(long carId);

    List<CompetitionDTO> getAllAvailableForReservation(LocalDate date);

}
