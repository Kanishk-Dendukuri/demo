package com.sos.schools.model;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
public class UpdateStudentModel {
    @Min(value = 1, message = "Id Can Not Be Less Than 1")
    @NotNull(message = "Id can not be empty or null")
    @NotEmpty(message = "Id can not be empty or null")
    private int id;

    @NotEmpty(message = "first name can not be empty or null")
    @NotNull(message = "first name can not be empty or null")
    private String firstName;


    @NotEmpty(message = "last name can not be empty or null")
    @NotNull(message = "last name can not be empty or null")
    private String lastName;
    @Email(message = "has to be valid email")
    private String email;
}

