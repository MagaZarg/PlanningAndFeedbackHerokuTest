package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.Building;
import com.amotek.planningandfeedback.core.domain.valueobject.Flat;
import com.amotek.planningandfeedback.core.domain.valueobject.Street;

public record Address(
        Country country,
        City city,
        Street street,
        Building building,
        Flat flat
) {
}
