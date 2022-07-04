package com.amotek.planningandfeedback.core.usecase;

import com.amotek.planningandfeedback.core.domain.valueobject.Feedbacks;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.GetFeedbackRepository;

public class GetFeedbacksUseCase {

    private final GetFeedbackRepository getFeedbackRepository;

    public GetFeedbacksUseCase(GetFeedbackRepository getFeedbackRepository) {
        this.getFeedbackRepository = getFeedbackRepository;
    }

    public Feedbacks query(Id trainingId) {
        return getFeedbackRepository.getAll(trainingId);
    }
}
