package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.model.User;

public interface UserService {

    User registerNewUser(User user);

    User getUserByUserName(String userName);

    User getUserByUsernameAndPassword(String username, String password);

    int resetUserPassword(String userName, String password);
}
