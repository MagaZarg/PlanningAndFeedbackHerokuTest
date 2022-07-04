package com.amotek.planningandfeedback.core.port;

import com.amotek.planningandfeedback.core.domain.Reservation;

public interface ReserveTrainingRepository {

    void save(Reservation reservation);

}
