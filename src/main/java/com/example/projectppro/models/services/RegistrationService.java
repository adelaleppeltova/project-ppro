package com.example.projectppro.models.services;


import com.example.projectppro.models.dto.RegistrationDTO;

import java.time.LocalDate;
import java.util.List;

public interface RegistrationService {
    RegistrationDTO addRegistration(RegistrationDTO registrationDTO);

    List<RegistrationDTO> getBooked(LocalDate date);

    List<RegistrationDTO> getAll();

    List<RegistrationDTO> getMyRegistrations(String email);

    void remove(long registrationId);

}
