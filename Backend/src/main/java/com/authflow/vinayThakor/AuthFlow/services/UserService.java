package com.authflow.vinayThakor.AuthFlow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.authflow.vinayThakor.AuthFlow.dto.UserDTO;
import com.authflow.vinayThakor.AuthFlow.model.UserEntity;
import com.authflow.vinayThakor.AuthFlow.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Collections;
import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        System.out.println("User found: " + user.getUsername() + ", Roles: " + user.getRoles());
        System.out.println("Encoded password: " + user.getPassword());

        String[] roles = user.getRoles() != null ? user.getRoles().split(",") : new String[] { "USER" };
        System.out.println("Roles array: " + Arrays.toString(roles));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }

    public UserDTO registerNewUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        if (userDTO.getRoles() == null || userDTO.getRoles().isEmpty()) {
            userDTO.setRoles(Collections.singletonList("USER"));
        }
        userEntity.setRoles(String.join(",", userDTO.getRoles()));

        UserEntity savedUser = userRepository.save(userEntity);
        System.out.println("User saved: " + savedUser.getUsername() + ", Roles: " + savedUser.getRoles());

        return userDTO;
    }

    public UserDTO newUser(UserDTO userDTO) {
        return registerNewUser(userDTO);
    }
}
