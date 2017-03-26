package com.vahan.service;

import com.vahan.domain.Users;
import com.vahan.repository.UserRepository;
import com.vahan.web.domain.UserPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by vahan on 3/25/17.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveUser(UserPageModel userPageModel) {

        Users users = new Users();

        users.setUsername(userPageModel.getUsername());

        users.setPassword(passwordEncoder.encode(userPageModel.getPassword()));

        users.setActivated(true);

        userRepository.save(users);

    }

    public void addUser(String username,String password){

        Users users = new Users();

        users.setUsername(username);

        users.setPassword(passwordEncoder.encode(password));

        users.setActivated(true);

        userRepository.save(users);
    }
}
