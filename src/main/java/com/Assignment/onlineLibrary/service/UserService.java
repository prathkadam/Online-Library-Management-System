package com.Assignment.onlineLibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Assignment.onlineLibrary.entity.userEntity;
import com.Assignment.onlineLibrary.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 1️⃣ Get all users
    public List<userEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // 3️⃣ Login User
    public userEntity login(String name, String email, String password, int months) {
        userEntity user = userRepository.findByEmail(email)
                .orElse(new userEntity());

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setLoggedIn(true);
        user.setMembershipEndDate(LocalDate.now().plusMonths(months));

        return userRepository.save(user);
    }

    // 6️⃣ Check Membership
    public boolean isMembershipValid(userEntity user) {
        return user.getMembershipEndDate().isAfter(LocalDate.now());
    }
}

