package com.sarmad.task.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "CAR_MODELS")
public class CarModel {
    @Id
    private String id;

    @Field("model_name")
    private String modelName;

    @Field("manufacturer")
    private String manufacturer;

    @Field("year")
    private int year;
}
