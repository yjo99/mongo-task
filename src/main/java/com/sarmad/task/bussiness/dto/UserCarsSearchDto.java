package com.sarmad.task.bussiness.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserCarsSearchDto {
    @NotNull(message = "cannot be Null")
    @NotBlank(message = "cannot be blank")
    private String firstName;

    private String secondName;

    private String carPlateNumber;
}
