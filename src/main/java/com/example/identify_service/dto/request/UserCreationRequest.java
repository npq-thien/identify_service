package com.example.identify_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {
    @Size(min = 3, message = "Username must contain more than 3 characters")
    private String username;

    @Size(min = 6, message = "Password must contain more than 8 characters")
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate dob;
}
