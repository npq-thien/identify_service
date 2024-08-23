package com.example.identify_service.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserUpdateRequest {
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate dob;
}
