package com.amotek.planningandfeedback.core.port;

import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.domain.valueobject.Trainings;

public interface GetTrainingsRepository {

    Trainings getAll();

    Training getById(Id id);

}
