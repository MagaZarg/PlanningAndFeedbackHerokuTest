package com.amotek.planningandfeedback;

import com.amotek.planningandfeedback.core.domain.*;
import com.amotek.planningandfeedback.core.domain.valueobject.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestApplication {

    public Training getTraining(String id) {
        return getTraining(id, 0);
    }

    public Training getTraining(String id, int amountOfParticipants) {

        return new Training(
                new Id(id),
                new TrainingName("Training 1"),
                new Description("Test description"),
                new ParticipantsCount(amountOfParticipants),
                new MaxParticipantsCount(10),
                new TrainingStartDate(LocalDate.now()),
                new TrainingDay("Monday"),
                new TrainingTime(LocalTime.of(13, 0)),
                new Duration(1D),
                getCoach("coach1"),
                getRoom("room1")
        );
    }

        public Reservation getReservation(String id, Training training, User user) {
            return new Reservation(new Id(id), user, training,
                    new ReservationDate(LocalDateTime.now()));
        }

    public Training getExpiredTraining(String id, String trainingName) {
        Address address = new Address(new Country("Armenia"),
                new City("Yerevan"),
                new Street("Avet Avertisian"),
                new Building("78"),
                new Flat("5"));

        return new Training(
                new Id(id),
                new TrainingName(trainingName),
                new Description("Test description"),
                new ParticipantsCount(1),
                new MaxParticipantsCount(10),
                new TrainingStartDate(LocalDate.now().plusMonths(1)),
                new TrainingDay("Monday"),
                new TrainingTime(LocalTime.of(13, 0)),
                new Duration(1D),
                getCoach("coach1"),
                getRoom("room1")
        );

    }

    public Training getExceededCapacityTraining(String id) {
        return getTraining(id, 10);
    }

    public User getUser(String userId) {
        return new User(new Id(userId), new FirstName("name1"), new LastName("lastName1"));
    }

    public Feedback getFeedback(String feedbackId, User user, Training training) {
        return new Feedback(
                new Id(feedbackId),
                user,
                training,
                new FeedbackMessage("feedback Message 1"));
    }

    public Coach getCoach(String coachId) {
        return new Coach(new Id(coachId),
                new FirstName("Erik"),
                new LastName("Hovhannisyan"));
    }

    public Room getRoom(String roomId) {
        Address address = new Address(
                new Country("Armenia"),
                new City("Yerevan"),
                new Street("Avet Avertisian"),
                new Building("78"),
                new Flat("5"));

        return new Room(
                new Id(roomId),
                new RoomName("Salsa"),
                new Gym(new GymName("Gym name"), address));
    }

}
