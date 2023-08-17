package com.sos.schools.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateStudentModel {

    private int id;

    @NotEmpty(message = "first name can not be empty or null")
    @NotNull(message = "nice ")
    private String firstName;


    @NotEmpty(message = "last name can not be empty or null")
    @NotNull(message = "nice ")
    private String lastName;

    @Email(message = "has to be valid email")
    private String email;
}
