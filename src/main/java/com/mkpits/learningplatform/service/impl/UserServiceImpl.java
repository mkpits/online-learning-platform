package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.repository.UserRepo;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerNewUser(User user) {

        User user1 = new User();

        user1.setDisplayName(user.getDisplayName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setMobileNumber(user.getMobileNumber());
        user1.setAge(user.getAge());
        user1.setRoleId(2);
        user1.setRoleValue("STUDENT");

        User saveNewUser = userRepo.save(user1);

        return saveNewUser;
    }
}
