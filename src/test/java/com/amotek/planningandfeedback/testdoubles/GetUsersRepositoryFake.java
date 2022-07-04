package com.amotek.planningandfeedback.testdoubles;

import com.amotek.planningandfeedback.core.domain.User;
import com.amotek.planningandfeedback.core.domain.valueobject.Id;
import com.amotek.planningandfeedback.core.port.GetUsersRepository;

import java.util.HashMap;
import java.util.Map;

public class GetUsersRepositoryFake implements GetUsersRepository {

    private final Map<Id, User> store = new HashMap<>();

    public void add(User user) {
        store.put(user.id(), user);
    }

    @Override
    public User get(Id id) {
        return store.get(id);
    }
}
