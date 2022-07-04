package com.amotek.planningandfeedback.core.usecase.validator;

import com.amotek.planningandfeedback.core.domain.Training;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReserveTrainingValidator {

    public void validateTraining(Training training) {
        validateStartDate(training);

        validateParticipantsCount(training);
    }

    private void validateParticipantsCount(Training training) {
        if (training.participantsCount().value() == training.maxParticipantsCount().value()) {
            throw new RuntimeException("Exceeded training capacity");
        }
    }

    private void validateStartDate(Training training) {
        if (training.trainingStartDate().value().isAfter(LocalDate.now())) {
            throw new RuntimeException("Expired date");
        }
    }

}
