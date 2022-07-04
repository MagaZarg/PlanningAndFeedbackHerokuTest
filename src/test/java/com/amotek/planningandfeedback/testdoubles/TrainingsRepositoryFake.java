package com.amotek.planningandfeedback.testdoubles;

import com.amotek.planningandfeedback.TestApplication;
import com.amotek.planningandfeedback.core.domain.Training;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.domain.valueobject.Trainings;
import com.amotek.planningandfeedback.core.port.GetTrainingsRepository;
import com.amotek.planningandfeedback.core.port.SaveTrainingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingsRepositoryFake implements GetTrainingsRepository, SaveTrainingsRepository {

    private final Map<Id, Training> store = new HashMap<>();
    private final TestApplication testApplication;

    public TrainingsRepositoryFake() {
        this.testApplication = new TestApplication();
        store.put(new Id("defaultTraining1"), testApplication.getTraining("defaultTraining1"));
        store.put(new Id("defaultTraining2"), testApplication.getTraining("defaultTraining2"));
    }

    @Override
    public Trainings getAll() {
        List<Training> trainingsList = new ArrayList<>(store.values());
        return new Trainings(trainingsList);
    }

    @Override
    public Training getById(Id id) {
        return store.get(id);
    }

    @Override
    public void save(Training training) {
        store.put(training.id(), training);
    }
}
