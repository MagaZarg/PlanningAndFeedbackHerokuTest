package com.amotek.planningandfeedback.core.domain;

import com.amotek.planningandfeedback.core.domain.valueobject.FirstName;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.domain.valueobject.LastName;

public record Coach(Id id,
                    FirstName firstName,
                    LastName lastName) {
    public Coach(Id id) {
        this(id, null, null);
    }
}
