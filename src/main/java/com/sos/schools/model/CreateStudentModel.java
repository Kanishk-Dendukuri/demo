package com.sos.schools.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateStudentModel {
    @NotEmpty(message = "first name can not be empty or null")
    @NotNull(message = "first name can not be empty or null")
    private String firstName;


    @NotEmpty(message = "last name can not be empty or null")
    @NotNull(message = "last name can not be empty or null")
    private String lastName;

    @Email(message = "has to be valid email")
    @NotEmpty(message = "Email can not be empty or null")
    @NotNull(message = "Email can not be empty or null")
    private String email;
}
