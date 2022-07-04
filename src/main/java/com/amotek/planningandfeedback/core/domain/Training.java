package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.*;

public record Training(
        Id id,
        TrainingName trainingName,
        Description description,
        ParticipantsCount participantsCount,
        MaxParticipantsCount maxParticipantsCount,
        TrainingStartDate trainingStartDate,
        TrainingDay trainingDay,
        TrainingTime trainingTime,
        Duration duration,
        Coach coach,
        Room room) {

    public Training incrementParticipantsCount() {
        return new Training(id,
                trainingName,
                description,
                new ParticipantsCount(participantsCount.value() + 1),
                maxParticipantsCount,
                trainingStartDate,
                trainingDay,
                trainingTime,
                duration,
                coach,
                room);
    }

    public Training(Id id,
                    TrainingName trainingName,
                    Description description,
                    ParticipantsCount participantsCount,
                    MaxParticipantsCount maxParticipantsCount,
                    TrainingStartDate trainingStartDate,
                    TrainingDay trainingDay,
                    TrainingTime trainingTime,
                    Duration duration) {
        this(id, trainingName, description, participantsCount, maxParticipantsCount, trainingStartDate, trainingDay, trainingTime, duration, null, null);
    }
}
