package com.sarmad.task.bussiness.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistrationDto {

    private String firstName;
    private String secondName;
    private String loginID;
    private String password;
}
