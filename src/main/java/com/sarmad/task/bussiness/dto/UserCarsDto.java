package com.sarmad.task.bussiness.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserCarsDto {

    private String modelName;
    private String manufacturerYear;
    private String type;
    private String color;
    private String carPlateNumber;
}
