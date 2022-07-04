package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.Id;

import java.util.Objects;

public record Reservation(Id id,
                          User user,
                          Training training,
                          ReservationDate reservationDate) {

    // TODO: 24.06.22 Deal with reservationDate

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(training, that.training);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, training);
    }
}
