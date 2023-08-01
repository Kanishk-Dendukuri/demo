package com.sos.schools.model;


import lombok.Data;

import javax.validation.constraints.*;


@Data
public class UpdateStudentModel {
    private int id;

    private String firstName;

    private String lastName;

    private String email;
}

