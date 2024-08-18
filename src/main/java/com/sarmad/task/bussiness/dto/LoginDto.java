package com.sarmad.task.bussiness.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginDto {
    private String loginID;
    private String password;
}
