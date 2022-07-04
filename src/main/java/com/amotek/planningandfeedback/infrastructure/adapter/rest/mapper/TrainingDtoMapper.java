package com.amotek.planningandfeedback.infrastructure.adapter.rest.mapper;

import com.amotek.planningandfeedback.core.domain.Coach;
import com.amotek.planningandfeedback.core.domain.Gym;
import com.amotek.planningandfeedback.core.domain.Room;
import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.infrastructure.adapter.rest.dto.TrainingDto;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TrainingDtoMapper {

    public TrainingDto domainToDto(Training training) {
        Coach coach = training.coach();
        Room room = training.room();
        Gym gym = room.gym();


        return new TrainingDto(training.id().value(),
                training.trainingName().value(),
                training.description().value(),
                training.participantsCount().value(),
                training.maxParticipantsCount().value(),
                training.trainingStartDate().value(),
                training.trainingDay().value(),
                training.trainingTime().value(),
                training.duration().value(),
                coach.firstName().value(),
                coach.lastName().value(),
                room.name().value()
        );
    }

    public List<TrainingDto> domainsToDtos(List<Training> entities) {
        List<TrainingDto> trainingDomains = new LinkedList<>();
        for (Training entity : entities) {
            trainingDomains.add(domainToDto(entity));
        }
        return trainingDomains;
    }

}
