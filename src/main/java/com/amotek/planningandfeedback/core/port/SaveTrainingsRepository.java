package com.amotek.planningandfeedback.core.port;

import com.amotek.planningandfeedback.core.domain.Training;

public interface SaveTrainingsRepository {
    void save(Training training);

}
