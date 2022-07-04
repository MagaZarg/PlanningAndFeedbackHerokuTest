package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.domain.valueobject.RoomName;

public record Room(
        Id id,
        RoomName name,
        Gym gym
) {
    public Room(Id id, RoomName name) {
        this(id, name, null);
    }
}
