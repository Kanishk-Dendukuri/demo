package com.sos.schools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Min(value = 0, message = "Id Can Not Be Less Than 0")
    private int id;

    @Valid
    @NotNull(message = "First Name Can Not Be Empty")
    @Size(max = 15, message = "Your First Name Is To Long Please Shorten It")
    private String firstName;

    @Valid
    @NotNull(message = "Last Name Can Not Be Empty")
    @Size(max = 15, message = "Your Last Name Is To Long Please Shorten It")
    private String lastName;


    @NotNull(message = "Email Can Not Be Empty")
    @Email(message = "Email Should Be Valid")
    private String email;

    public Student(String firstName, String lastName,String Email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = Email;
    }

}
