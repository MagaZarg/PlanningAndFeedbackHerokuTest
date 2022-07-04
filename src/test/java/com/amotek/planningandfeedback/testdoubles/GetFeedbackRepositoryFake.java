package com.amotek.planningandfeedback.testdoubles;

import com.amotek.planningandfeedback.TestApplication;
import com.amotek.planningandfeedback.core.domain.valueobject.Feedbacks;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.GetFeedbackRepository;

import java.util.List;

public class GetFeedbackRepositoryFake implements GetFeedbackRepository {
    private final TestApplication context;

    public GetFeedbackRepositoryFake() {
        this.context = new TestApplication();
    }

    @Override
    public Feedbacks getAll(Id trainingId) {
        return new Feedbacks(List.of(context.getFeedback("feedback1",
                context.getUser("user1"),
                context.getTraining("defaultTraining1"))));
    }
}
