package com.amotek.planningandfeedback.infrastructure.adapter.persistance.mapper;

import com.amotek.planningandfeedback.core.domain.*;
import com.amotek.planningandfeedback.core.domain.valueobject.*;
import com.amotek.planningandfeedback.infrastructure.adapter.persistance.entity.TrainingEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TrainingEntityMapper {

    // TODO: 30.06.22 remove the hardcoded fields in Coach and Room entities
    public Training entityToDomain(TrainingEntity entity) {
        return new Training(new Id(entity.getUuid()),
                new TrainingName(entity.getName()),
                new Description(entity.getDescription()),
                new ParticipantsCount(entity.getParticipantsCount()),
                new MaxParticipantsCount(entity.getMaxParticipantsCount()),
                new TrainingStartDate(entity.getTrainingStartDate().toLocalDate()),
                new TrainingDay(entity.getTrainingDay()),
                new TrainingTime(entity.getTrainingTime().toLocalTime()),
                new Duration(entity.getDuration()),
                new Coach(new Id(entity.getCoachUuid()), new FirstName("Erik"), new LastName("Hovhannisyan")),
                new Room(new Id(entity.getRoomUuid()), new RoomName("Room1"))
        );
    }

    public Trainings entitiesToDomain(List<TrainingEntity> entities) {
        List<Training> trainingDomains = new LinkedList<>();
        for (TrainingEntity entity : entities) {
            trainingDomains.add(entityToDomain(entity));
        }
        return new Trainings(trainingDomains);
    }

}
