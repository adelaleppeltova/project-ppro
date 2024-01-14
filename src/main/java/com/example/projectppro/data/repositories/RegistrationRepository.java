package com.example.projectppro.data.repositories;

import com.example.projectppro.data.entities.RegistrationEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface RegistrationRepository extends CrudRepository<RegistrationEntity, Long> {

    List<RegistrationEntity> getAllByDateEquals(LocalDate date);

    List<RegistrationEntity> getAllByUserEmail(String email);
}

