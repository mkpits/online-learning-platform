package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.repository.UserRepo;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerNewUser(User user) {

        user.setDisplayName(user.getDisplayName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setMobileNumber(user.getMobileNumber());
        user.setAge(user.getAge());
        user.setRoleId(2);
        user.setRoleValue("STUDENT");
        user.setCreatedAt(LocalDateTime.now());

        User saveNewUser = userRepo.save(user);

        return saveNewUser;
    }

    @Override
    public User getUserByUserName(String userName) {

        User searchedUser = userRepo.getUserByUserName(userName);

        return searchedUser;
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        User searchedUserFromDB = userRepo.getUserByUsernameAndPassword(username, password);

        return searchedUserFromDB;
    }
    @Override
    @Transactional
    public int resetUserPassword(String userName, String password) {

        int resetPassword = userRepo.updatePasswordByEmail(userName, password);

        return resetPassword;
    }
}
