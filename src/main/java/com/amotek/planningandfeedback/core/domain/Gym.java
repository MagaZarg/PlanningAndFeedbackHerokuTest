package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.GymName;

public record Gym(
        GymName name,
        Address address
) {

}
