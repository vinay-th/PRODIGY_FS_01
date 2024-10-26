package com.authflow.vinayThakor.AuthFlow.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.authflow.vinayThakor.AuthFlow.dto.UserDTO;
import com.authflow.vinayThakor.AuthFlow.entities.UserEntity;
import com.authflow.vinayThakor.AuthFlow.repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepo;

    final ModelMapper modelMapper;

    public UserService(UserRepository userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    public UserDTO getUserByID(Long id) {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserDTO newUser(UserDTO userDTO) {
        System.out.println("UserDTO before mapping: " + userDTO);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        System.out.println("UserEntity after mapping: " + userEntity);
        UserEntity savedEntity = userRepo.save(userEntity);
        System.out.println("Saved UserEntity: " + savedEntity);
        UserDTO result = modelMapper.map(savedEntity, UserDTO.class);
        System.out.println("Final UserDTO: " + result);
        return result;
    }
}
