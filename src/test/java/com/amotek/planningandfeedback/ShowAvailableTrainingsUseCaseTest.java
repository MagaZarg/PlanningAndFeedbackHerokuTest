package com.amotek.planningandfeedback;

import com.amotek.planningandfeedback.core.usecase.ShowAvailableTrainingsUseCase;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.mapper.TrainingDtoMapper;
import com.amotek.planningandfeedback.testdoubles.TrainingsRepositoryFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShowAvailableTrainingsUseCaseTest {

    private TestApplication testApplication;

    private TrainingDtoMapper trainingDtoMapper;

    @BeforeEach
    void setUp() {
        testApplication = new TestApplication();
        trainingDtoMapper = new TrainingDtoMapper();
    }

    @Test
    void getAll2() {
        //given
        TrainingsRepositoryFake trainingsRepositoryFake = new TrainingsRepositoryFake();
        ShowAvailableTrainingsUseCase showAvailableTrainingsUseCase =
                new ShowAvailableTrainingsUseCase(trainingsRepositoryFake, trainingDtoMapper);

        //when
        List<TrainingDto> actual = showAvailableTrainingsUseCase.query();

        //then
        List<TrainingDto> expected = List.of(trainingDtoMapper.domainToDto(testApplication.getTraining("defaultTraining2")),
                trainingDtoMapper.domainToDto(testApplication.getTraining("defaultTraining1")));

        assertTrue(expected.containsAll(actual));
    }

}
