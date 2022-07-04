package com.amotek.planningandfeedback.infrastructure.adapter.rest.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record TrainingDto(String id,
                          String name,
                          String description,
                          int participantsCount,
                          int maxParticipantsCount,
                          LocalDate startDate,
                          String day,
                          LocalTime time,
                          Double duration,
                          String coachFirstName,
                          String coachLastName,
                          String roomName) {

}
