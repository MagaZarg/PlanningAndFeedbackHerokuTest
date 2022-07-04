package com.amotek.planningandfeedback;

import com.amotek.planningandfeedback.core.domain.Reservation;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.usecase.ReserveTrainingUseCase;
import com.amotek.planningandfeedback.core.usecase.command.ReserveCommand;
import com.amotek.planningandfeedback.core.usecase.validator.ReserveTrainingValidator;
import com.amotek.planningandfeedback.testdoubles.GetUsersRepositoryFake;
import com.amotek.planningandfeedback.testdoubles.ReserveTrainingRepositoryFake;
import com.amotek.planningandfeedback.testdoubles.TrainingsRepositoryFake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReserveTrainingUseCaseTest {

    private TestApplication context;
    TrainingsRepositoryFake trainingsRepositoryFake;

    GetUsersRepositoryFake getUsersRepositoryFake;
    ReserveTrainingRepositoryFake reserveTrainingRepositoryFake;
    ReserveTrainingUseCase reserveTrainingUseCase;
    ReserveTrainingValidator reserveTrainingValidator;

    @BeforeEach
    void setUp() {
        context = new TestApplication();
        trainingsRepositoryFake = new TrainingsRepositoryFake();
        getUsersRepositoryFake = new GetUsersRepositoryFake();
        reserveTrainingRepositoryFake = new ReserveTrainingRepositoryFake();
        reserveTrainingValidator = new ReserveTrainingValidator();

        reserveTrainingUseCase = new ReserveTrainingUseCase(reserveTrainingRepositoryFake,
                trainingsRepositoryFake,
                getUsersRepositoryFake,
                trainingsRepositoryFake,
                reserveTrainingValidator);
    }

    @Test
    void reserve() {
        // given
        trainingsRepositoryFake.save(context.getTraining("defaultTraining1"));
        getUsersRepositoryFake.add(context.getUser("user1"));

        // when
        ReserveCommand reserveCommand = new ReserveCommand(new Id("defaultTraining1"), new Id("user1"));
        reserveTrainingUseCase.execute(reserveCommand);
        Map<Id, Reservation> actual = reserveTrainingRepositoryFake.getAll();

        //then
        Map<Id, Reservation> expected = new HashMap<>();
        expected.put(
                new Id("reservation1"),
                context.getReservation("reservation1",
                        context.getTraining("defaultTraining1", 1),
                        context.getUser("user1")));

        assertEquals(expected, actual);
    }

    @Test
    void reserveExpiredDate() {
        //given
        trainingsRepositoryFake.save(context.getExpiredTraining("defaultTraining2", "Training 2"));
        ReserveCommand reserveCommand = new ReserveCommand(new Id("defaultTraining2"), new Id("Training 2"));

        //when
        Exception actualException = assertThrows(RuntimeException.class, () -> reserveTrainingUseCase.execute(reserveCommand));
        String actual = actualException.getMessage();

        //then
        String expected = "Expired date";
        assertEquals(expected, actual);
    }

    @Test
    void reserveExceededCapacity() {
        //given
        trainingsRepositoryFake.save(context.getExceededCapacityTraining("defaultTraining3"));
        ReserveCommand reserveCommand = new ReserveCommand(new Id("defaultTraining3"), new Id("Training 3"));

        //when
        Exception actualException = assertThrows(RuntimeException.class, () -> reserveTrainingUseCase.execute(reserveCommand));
        String actual = actualException.getMessage();

        //then
        String expected = "Exceeded training capacity";
        assertEquals(expected, actual);
    }

}
