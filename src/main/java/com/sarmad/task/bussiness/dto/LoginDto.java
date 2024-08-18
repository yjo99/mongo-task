package com.sarmad.task.bussiness.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginDto {
    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    private String loginID;

    private String password;
}
