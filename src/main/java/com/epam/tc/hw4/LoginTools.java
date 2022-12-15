package com.epam.tc.hw4;

import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginTools {

    public static final User EMPTY_USER = new User("", "");

    @Step
    public void typeLogin(@NonNull final String username) {
    }

    public void typePassword(@NonNull final String password) {
    }

    @Step("text {user.name} : {user.password}")
    public void login(@NonNull final User user) {
        if (EMPTY_USER.equals(user)) {
            throw new IllegalArgumentException("Empty user :(");
        }
        typeLogin(user.getName());
        typePassword(user.getPassword());
    }
}
