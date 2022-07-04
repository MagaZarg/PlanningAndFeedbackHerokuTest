package com.amotek.planningandfeedback.core.usecase;

import com.amotek.planningandfeedback.core.domain.valueobject.Trainings;
import com.amotek.planningandfeedback.core.port.GetTrainingsRepository;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.mapper.TrainingDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAvailableTrainingsUseCase {
    private final GetTrainingsRepository getTrainingsRepository;
    private final TrainingDtoMapper trainingDtoMapper;

    public ShowAvailableTrainingsUseCase(GetTrainingsRepository getTrainingsRepository, TrainingDtoMapper trainingDtoMapper) {
        this.getTrainingsRepository = getTrainingsRepository;
        this.trainingDtoMapper = trainingDtoMapper;
    }

    public List<TrainingDto> query() {
        Trainings trainings = getTrainingsRepository.getAll();
        return trainingDtoMapper.domainsToDtos(trainings.values());
    }

}
