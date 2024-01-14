package com.example.projectppro.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CompetitionDTO {
    private long competitionId;

    @NotBlank(message = "Vyplňte značku vozidla")
    private String competitionModel;

    @NotBlank(message = "Vyplňte SPZ")
    @Size(max = 8, message = "SPZ je příliš dlouhá")
    private String registrationNumber;

    @NotBlank(message = "Vyplňte popis")
    private String description;

    @Positive(message = "Vyplňte cenu za půjčení")
    private int rentalPrice;

    private String imagePath;

    private boolean isAvailable;

    private boolean isDeleted = false;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionModel() {
        return competitionModel;
    }

    public void setCompetitionModel(String competitionModel) {
        this.competitionModel = competitionModel;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}