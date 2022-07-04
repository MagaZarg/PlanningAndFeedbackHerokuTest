package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.FeedbackMessage;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;

public record Feedback(
        Id id,
        User user,
        Training training,
        FeedbackMessage message
) {

}
