package com.amotek.planningandfeedback.core.port;

import com.amotek.planningandfeedback.core.domain.User;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;

public interface GetUsersRepository {

    User get(Id id);

}
