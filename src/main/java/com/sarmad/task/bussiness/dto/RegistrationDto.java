package com.sarmad.task.bussiness.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistrationDto {

    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    private String firstName;
    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    private String secondName;
    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    private String loginID;
    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    @Min(value = 6, message = "Password should be greater than 6")
    private String password;
}
