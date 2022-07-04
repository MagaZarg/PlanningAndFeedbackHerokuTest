package com.amotek.planningandfeedback.infrastructure.adapter.persistance.repository;

import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.domain.valueobject.Trainings;
import com.amotek.planningandfeedback.core.port.GetTrainingsRepository;
import com.amotek.planningandfeedback.infrastructure.adapter.persistance.entity.TrainingEntity;
import com.amotek.planningandfeedback.infrastructure.adapter.persistance.mapper.TrainingEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetTrainingsMySQLRepository implements GetTrainingsRepository {

    private final GetTrainingsJpaRepository getTrainingsJpaRepository;
    private final TrainingEntityMapper trainingEntityMapper;

    public GetTrainingsMySQLRepository(GetTrainingsJpaRepository getTrainingsJpaRepository, TrainingEntityMapper trainingEntityMapper) {
        this.getTrainingsJpaRepository = getTrainingsJpaRepository;
        this.trainingEntityMapper = trainingEntityMapper;
    }

    @Override
    public Trainings getAll() {
        List<TrainingEntity> trainingEntities = getTrainingsJpaRepository.findAll();

        return trainingEntityMapper.entitiesToDomain(trainingEntities);
    }

    @Override
    public Training getById(Id id) {
        Optional<TrainingEntity> trainingEntity = getTrainingsJpaRepository.findById(id.value());
        return trainingEntity.map(trainingEntityMapper::entityToDomain).orElse(null);
    }

}
