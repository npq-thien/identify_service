package com.example.identify_service.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdateRequest {
    private String password;
    private String lastName;
    private String firstName;
    private LocalDate dob;
}
