package com.amotek.planningandfeedback.testdoubles;

import com.amotek.planningandfeedback.core.domain.Reservation;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.ReserveTrainingRepository;

import java.util.HashMap;
import java.util.Map;

public class ReserveTrainingRepositoryFake implements ReserveTrainingRepository {
    private final Map<Id, Reservation> store = new HashMap<>();

    @Override
    public void save(Reservation reservation) {
        store.put(reservation.id(), reservation);
    }

    public Map<Id, Reservation> getAll() {
        return store;
    }
}
