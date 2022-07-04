package com.amotek.planningandfeedback.infrastructure.adapter.rest.controller;

import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.usecase.ShowAvailableTrainingsUseCase;
import com.amotek.planningandfeedback.core.usecase.ShowTrainingUseCase;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    private final ShowAvailableTrainingsUseCase showAvailableTrainingsUseCase;
    private final ShowTrainingUseCase showTrainingUseCase;

    public TrainingController(ShowAvailableTrainingsUseCase showAvailableTrainingsUseCase, ShowTrainingUseCase showTrainingUseCase) {
        this.showAvailableTrainingsUseCase = showAvailableTrainingsUseCase;
        this.showTrainingUseCase = showTrainingUseCase;
    }

    @GetMapping
    public List<TrainingDto> getAvailableTrainings() {
        return showAvailableTrainingsUseCase.query();
    }

    @GetMapping("/{id}")
    public TrainingDto getTrainingById(@PathVariable String id) {
        return showTrainingUseCase.query(new Id(id));
    }

}
