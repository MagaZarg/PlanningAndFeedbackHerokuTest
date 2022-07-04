package com.amotek.planningandfeedback;

import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.usecase.ShowTrainingUseCase;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.mapper.TrainingDtoMapper;
import com.amotek.planningandfeedback.testdoubles.TrainingsRepositoryFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowTrainingUseCaseTest {

    private TestApplication testApplication;
    private TrainingDtoMapper trainingDtoMapper;

    @BeforeEach
    void setUp() {
        testApplication = new TestApplication();
        trainingDtoMapper = new TrainingDtoMapper();
    }

    @Test
    void get2() {
        //given
        TrainingsRepositoryFake trainingsRepositoryFake = new TrainingsRepositoryFake();
        ShowTrainingUseCase showTrainingUseCase = new ShowTrainingUseCase(trainingsRepositoryFake, trainingDtoMapper);

        //when
        TrainingDto actual = showTrainingUseCase.query(new Id("defaultTraining1"));

        //then
        TrainingDto expected = trainingDtoMapper.domainToDto(testApplication.getTraining("defaultTraining1"));

        assertEquals(expected, actual);
    }

}
