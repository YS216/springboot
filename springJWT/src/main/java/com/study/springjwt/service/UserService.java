package com.study.springjwt.service;

import com.study.springjwt.domain.UserEntity;
import com.study.springjwt.dto.EnrollUser;
import com.study.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
   UserRepository userRepository;

   @Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder;

    public void userEnroll(EnrollUser enrollUser) {
        UserEntity data = new UserEntity();
        data.setUsername(enrollUser.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(enrollUser.getPassword()));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
