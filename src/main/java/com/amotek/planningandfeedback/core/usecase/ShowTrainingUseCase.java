package com.amotek.planningandfeedback.core.usecase;

import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.GetTrainingsRepository;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.mapper.TrainingDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class ShowTrainingUseCase {

    private final GetTrainingsRepository getTrainingsRepository;
    private final TrainingDtoMapper trainingDtoMapper;

    public ShowTrainingUseCase(GetTrainingsRepository getTrainingsRepository, TrainingDtoMapper trainingDtoMapper) {
        this.getTrainingsRepository = getTrainingsRepository;
        this.trainingDtoMapper = trainingDtoMapper;
    }

    public TrainingDto query(Id id) {
        Training training = getTrainingsRepository.getById(id);
        return trainingDtoMapper.domainToDto(training);
    }

}
