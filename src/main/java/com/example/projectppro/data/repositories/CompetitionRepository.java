package com.example.projectppro.data.repositories;

import com.example.projectppro.data.entities.CompetitionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CompetitionRepository extends CrudRepository<CompetitionEntity, Long> {
    List<CompetitionEntity> getAllByIsDeleted(boolean isDeleted);

    @Query("SELECT c FROM CompetitionEntity AS c WHERE NOT EXISTS (SELECT r FROM RegistrationEntity AS r WHERE r.competition = c AND r.date = :date) AND c.isDeleted = false AND c.isAvailable = true")
    List<CompetitionEntity> findAvailableCompetitionsForDate(@Param("date") LocalDate date);

}
