package com.app.utils;

import com.app.models.User;

public class ValidateUtils {
    private ValidateUtils() {}

    public static boolean userIsNull(User u) {
        return u == null;
    }
}
