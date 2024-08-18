package com.sarmad.task.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@Document(collection = "USER_CARS")
public class UserCars {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("car_model_id")
    private String carModelId;

    @Field("color")
    private String color;

    @Field("car_plate_number")
    private String carPlateNumber;

}
