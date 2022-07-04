package com.amotek.planningandfeedback.core.usecase.command;

import com.amotek.planningandfeedback.core.domain.valueobject.Id;

public class ReserveCommand {
    private Id trainingId;
    private Id userId;

    public ReserveCommand(Id trainingId, Id userId) {
        this.trainingId = trainingId;
        this.userId = userId;
    }

    public Id getTrainingId() {
        return trainingId;
    }

    public Id getUserId() {
        return userId;
    }
}
