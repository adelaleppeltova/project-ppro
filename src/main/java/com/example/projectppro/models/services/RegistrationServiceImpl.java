package com.example.projectppro.models.services;


import com.example.projectppro.data.entities.CompetitionEntity;
import com.example.projectppro.data.entities.RegistrationEntity;
import com.example.projectppro.data.entities.UserEntity;
import com.example.projectppro.data.repositories.RegistrationRepository;
import com.example.projectppro.data.repositories.UserRepository;
import com.example.projectppro.models.dto.RegistrationDTO;
import com.example.projectppro.models.dto.mappers.RegistrationMapper;
import com.example.projectppro.models.exceptions.CompetitionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CompetitionServiceImpl competitionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public RegistrationDTO addRegistration(RegistrationDTO registrationDTO) {
        RegistrationEntity registration = registrationMapper.toEntity(registrationDTO);

        CompetitionEntity competition = competitionService.getCompetitionOrThrow(registrationDTO.getCompetitionId());
        registration.setCompetition(competition);

        UserEntity user = userRepository.findById(registrationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Uživatel nenalezen"));
        registration.setUser(user);

        RegistrationEntity saved = registrationRepository.save(registration);
        return registrationMapper.toDTO(saved);
    }

    @Override
    public List<RegistrationDTO> getBooked(LocalDate date) {
        return registrationRepository.getAllByDateEquals(date).stream()
                .map(registrationMapper::toDTO)
                .toList();
    }

    @Override
    public List<RegistrationDTO> getAll() {
        return StreamSupport.stream(registrationRepository.findAll().spliterator(), false)
                .map(i -> registrationMapper.toDTO(i))
                .toList();
    }

    @Override
    public List<RegistrationDTO> getMyRegistrations(String email) {
        return registrationRepository.getAllByUserEmail(email).stream()
                .map(registrationMapper::toDTO)
                .toList();
    }
    @Override
    public void remove(long registrationId) {
        RegistrationEntity selectedRegistration = getRegistrationOrThrow(registrationId);
        registrationRepository.delete(selectedRegistration);
    }

    protected RegistrationEntity getRegistrationOrThrow(long registrationId) {
        return registrationRepository
                .findById(registrationId)
                .orElseThrow(CompetitionNotFoundException::new);
    }
}
