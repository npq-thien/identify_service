package com.example.identify_service.service;

import com.example.identify_service.dto.request.UserCreationRequest;
import com.example.identify_service.dto.request.UserUpdateRequest;
import com.example.identify_service.entity.User;
import com.example.identify_service.exception.AppException;
import com.example.identify_service.exception.ErrorCode;
import com.example.identify_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        UserCreationRequest userCreationRequest = new UserCreationRequest();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());

        return userRepository.save(user);
    };

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUser(id);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
