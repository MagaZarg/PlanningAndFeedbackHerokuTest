package com.amotek.planningandfeedback.core.usecase;

import com.amotek.planningandfeedback.core.domain.Reservation;
import com.amotek.planningandfeedback.core.domain.ReservationDate;
import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.core.domain.User;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.GetTrainingsRepository;
import com.amotek.planningandfeedback.core.port.GetUsersRepository;
import com.amotek.planningandfeedback.core.port.ReserveTrainingRepository;
import com.amotek.planningandfeedback.core.port.SaveTrainingsRepository;
import com.amotek.planningandfeedback.core.usecase.command.ReserveCommand;
import com.amotek.planningandfeedback.core.usecase.validator.ReserveTrainingValidator;

import java.time.LocalDateTime;

public class ReserveTrainingUseCase {

    private final ReserveTrainingRepository reserveTrainingRepository;
    private final GetTrainingsRepository getTrainingsRepository;
    private final GetUsersRepository getUsersRepository;
    private final SaveTrainingsRepository saveTrainingsRepository;
    private final ReserveTrainingValidator reserveTrainingValidator;

    public ReserveTrainingUseCase(ReserveTrainingRepository reserveTrainingRepository, GetTrainingsRepository getTrainingsRepository, GetUsersRepository getUsersRepository, SaveTrainingsRepository saveTrainingsRepository, ReserveTrainingValidator reserveTrainingValidator) {
        this.reserveTrainingRepository = reserveTrainingRepository;
        this.getTrainingsRepository = getTrainingsRepository;
        this.getUsersRepository = getUsersRepository;
        this.saveTrainingsRepository = saveTrainingsRepository;
        this.reserveTrainingValidator = reserveTrainingValidator;
    }

    public void execute(ReserveCommand reserveCommand) {
        Training training = getTrainingsRepository.getById(reserveCommand.getTrainingId());

        reserveTrainingValidator.validateTraining(training);

        User user = getUsersRepository.get(reserveCommand.getUserId());

        training = training.incrementParticipantsCount();
        saveTrainingsRepository.save(training);

        Reservation reservation = new Reservation(
                new Id("reservation1"),
                user,
                training,
                new ReservationDate(LocalDateTime.now()));

        reserveTrainingRepository.save(reservation);
    }

}
