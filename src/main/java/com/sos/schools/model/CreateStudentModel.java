package com.sos.schools.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

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
