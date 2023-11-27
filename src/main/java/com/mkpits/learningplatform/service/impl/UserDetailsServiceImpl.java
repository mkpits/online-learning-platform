package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.configuration.CustomUserDetailsConfig;
import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {  // 2nd step

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.getUserByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not found user");
        }

        CustomUserDetailsConfig customUserDetails = new CustomUserDetailsConfig(user);

        return customUserDetails;
    }
}
