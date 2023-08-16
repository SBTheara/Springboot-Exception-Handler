package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//this class use for front end or post man want to input or post request
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class Users_Request {
    @NotBlank(message = "Please input the name")
    private String name;
    @Email
    @NotNull(message = "Please input the email")
    @NotBlank(message = "Please input the email")
    private String email;
    @NotNull(message = "Please input the mobile")
    private String mobile;
    @NotBlank
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
