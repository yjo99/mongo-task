package com.sarmad.task.bussiness.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoginResponseDto {
    public String accessToken;
}
