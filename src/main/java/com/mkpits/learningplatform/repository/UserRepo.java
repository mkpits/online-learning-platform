package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :email")
    User getUserByUserName(@Param("email") String email);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User getUserByUsernameAndPassword(@Param("email") String email, @Param("password") String password);
}
