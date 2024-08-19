package com.sarmad.task.bussiness.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserCarsDto {
    @Field("user_id")
    private String userId;

    @Field("car_model_id")
    private String carModelId;

    @Field("color")
    private String color;

    @Field("car_plate_number")
    private String carPlateNumber;
}
