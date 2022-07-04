package com.amotek.planningandfeedback.core.port;

import com.amotek.planningandfeedback.core.domain.valueobject.Feedbacks;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;

public interface GetFeedbackRepository {

    Feedbacks getAll(Id trainingId);

}
