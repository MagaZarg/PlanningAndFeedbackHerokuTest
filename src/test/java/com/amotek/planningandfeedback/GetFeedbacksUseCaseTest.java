package com.amotek.planningandfeedback;

import com.amotek.planningandfeedback.core.domain.valueobject.Feedbacks;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.usecase.GetFeedbacksUseCase;
import com.amotek.planningandfeedback.testdoubles.GetFeedbackRepositoryFake;
import com.amotek.planningandfeedback.testdoubles.GetUsersRepositoryFake;
import com.amotek.planningandfeedback.testdoubles.TrainingsRepositoryFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetFeedbacksUseCaseTest {
    TestApplication context;
    GetFeedbackRepositoryFake getFeedbackRepositoryFake;
    GetFeedbacksUseCase getFeedbacksUseCase;
    GetUsersRepositoryFake getUsersRepositoryFake;
    TrainingsRepositoryFake trainingsRepositoryFake;

    @BeforeEach
    void setUp() {
        context = new TestApplication();
        getFeedbackRepositoryFake = new GetFeedbackRepositoryFake();
        getUsersRepositoryFake = new GetUsersRepositoryFake();
        trainingsRepositoryFake = new TrainingsRepositoryFake();
        getFeedbacksUseCase = new GetFeedbacksUseCase(getFeedbackRepositoryFake);

    }

    @Test
    void getAllFeedbacks() {
        //given

        //when
        Feedbacks actual = getFeedbacksUseCase.query(new Id("defaultTraining1"));

        //then
        Feedbacks expected = new Feedbacks(List.of(
                context.getFeedback("feedback1",
                        context.getUser("user1"),
                        context.getTraining("defaultTraining1"))));

        assertEquals(actual, expected);
    }

}
